
#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
#include <string>
#include <limits>
using namespace std;

// Class representing one account
class PasswordEntry {
private:
    string website;
    string username;
    string password;

public:
    // Constructor
    PasswordEntry(string w, string u, string p) {
        website = w;
        username = u;
        password = p;
    }

    // Getter functions
    string getWebsite() const {
        return website;
    }

    string getUsername() const {
        return username;
    }

    string getPassword() const {
        return password;
    }

    // Update account details
    void updateDetails(string u, string p) {
        username = u;
        password = p;
    }

    // Display account details
    void display() const {
        cout << "Website : " << website << endl;
        cout << "Username: " << username << endl;
        cout << "Password: " << password << endl;
        cout << "--------------------------\n";
    }
};

// Class managing all password entries
class PasswordManager {
private:
    vector<PasswordEntry> entries;
    const string filename = "passwords.txt";

    // Find an account using linear search
    int findEntry(string website) const {
        for (int i = 0; i < (int)entries.size(); i++) {
            if (entries[i].getWebsite() == website) {
                return i;
            }
        }
        return -1;
    }

    // Save all records to a file
    void saveToFile() const {
        ofstream file(filename);

        if (!file) {
            cout << "Error saving file!\n";
            return;
        }

        for (const auto& entry : entries) {
            file << entry.getWebsite() << '\n';
            file << entry.getUsername() << '\n';
            file << entry.getPassword() << '\n';
        }

        file.close();
    }

    // Load saved records from a file
    void loadFromFile() {
        ifstream file(filename);

        if (!file) {
            return;
        }

        string website, username, password;

        while (getline(file, website) &&
               getline(file, username) &&
               getline(file, password)) {
            entries.emplace_back(website, username, password);
        }

        file.close();
    }

public:
    // Constructor loads existing records
    PasswordManager() {
        loadFromFile();
    }

    // Add a new account
    void addEntry() {
        string website, username, password;

        cout << "Enter website: ";
        getline(cin, website);

        if (website.empty()) {
            cout << "Website cannot be empty!\n";
            return;
        }

        if (findEntry(website) != -1) {
            cout << "Account already exists!\n";
            return;
        }

        cout << "Enter username: ";
        getline(cin, username);

        cout << "Enter password: ";
        getline(cin, password);

        entries.emplace_back(website, username, password);

        saveToFile();
        cout << "Account added successfully!\n";
    }

    // Display all accounts
    void displayAll() const {
        if (entries.empty()) {
            cout << "No accounts found.\n";
            return;
        }

        for (const auto& entry : entries) {
            entry.display();
        }
    }

    // Search for an account
    void searchEntry() const {
        string website;

        cout << "Enter website to search: ";
        getline(cin, website);

        int index = findEntry(website);

        if (index == -1) {
            cout << "Account not found!\n";
        } else {
            entries[index].display();
        }
    }

    // Update an account
    void updateEntry() {
        string website, username, password;

        cout << "Enter website to update: ";
        getline(cin, website);

        int index = findEntry(website);

        if (index == -1) {
            cout << "Account not found!\n";
            return;
        }

        cout << "Enter new username: ";
        getline(cin, username);

        cout << "Enter new password: ";
        getline(cin, password);

        entries[index].updateDetails(username, password);

        saveToFile();
        cout << "Account updated successfully!\n";
    }

    // Delete an account
    void deleteEntry() {
        string website;

        cout << "Enter website to delete: ";
        getline(cin, website);

        int index = findEntry(website);

        if (index == -1) {
            cout << "Account not found!\n";
            return;
        }

        entries.erase(entries.begin() + index);

        saveToFile();
        cout << "Account deleted successfully!\n";
    }

    // Sort accounts by website
    void sortEntries() {
        sort(entries.begin(), entries.end(),
             [](const PasswordEntry& a, const PasswordEntry& b) {
                 return a.getWebsite() < b.getWebsite();
             });

        cout << "Accounts sorted by website!\n";
    }
};

// Main function
int main() {
    PasswordManager manager;
    int choice;

    do {
        cout << "\n===== PASSWORD MANAGER =====\n";
        cout << "1. Add Account\n";
        cout << "2. Display All Accounts\n";
        cout << "3. Search Account\n";
        cout << "4. Update Account\n";
        cout << "5. Delete Account\n";
        cout << "6. Sort Accounts\n";
        cout << "0. Exit\n";
        cout << "Enter your choice: ";

        if (!(cin >> choice)) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input!\n";
            continue;
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        switch (choice) {
            case 1:
                manager.addEntry();
                break;

            case 2:
                manager.displayAll();
                break;

            case 3:
                manager.searchEntry();
                break;

            case 4:
                manager.updateEntry();
                break;

            case 5:
                manager.deleteEntry();
                break;

            case 6:
                manager.sortEntries();
                break;

            case 0:
                cout << "Thank you for using Password Manager!\n";
                break;

            default:
                cout << "Invalid choice! Try again.\n";
        }

    } while (choice != 0);

    return 0;
}