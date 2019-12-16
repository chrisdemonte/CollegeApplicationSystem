package com.yahoo.demonte.chris.schoolfinder;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserManager {

    public static TreeMap<String, User> userAccounts = new TreeMap<String, User>();
    public static User currentUser = null;

    public UserManager(Context c) {
        this.loadAccounts(c);
    }

    public static boolean addAccount(Context c, User user) {
        if (userAccounts.get(user.getUsername()) == null) {
            userAccounts.put(user.getUsername(), user);
            saveAccounts(c);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkAccount(String username, String password) {
        if (userAccounts.containsKey(username)){
            if (userAccounts.get(username).getPassword().contentEquals(password)){
                currentUser = userAccounts.get(username);
                return true;
            }
        }
        return false;
    }

    public static void loadAccounts(Context c){
        BufferedReader br = null;
        try {
            File file = new File(c.getFilesDir(), "college_user_accounts.txt");
            if (file.exists()){
                br = new BufferedReader(new FileReader(file));
                String name;
                while ((name = br.readLine()) != null){
                    String username = br.readLine();
                    String password = br.readLine();
                    String email = br.readLine();
                    int mathScore = Integer.parseInt(br.readLine());
                    int readingScore = Integer.parseInt(br.readLine());
                    String favs = br.readLine();
                    ArrayList<String> favorites = new ArrayList<String>();
                    if (!favs.contentEquals("-1")) {
                        String[] arr = favs.split(",");
                        for (int i = 0; i < arr.length; i++) {
                            favorites.add(arr[i]);
                        }
                    }
                    User user = new User(name, username, password, email, mathScore, readingScore);
                    user.setFavorites(favorites);
                    userAccounts.put(username, user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void saveAccounts(Context c){
        String output = "";
        Set set = userAccounts.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            output += userAccounts.get(pair.getKey()).toSpecialString();
        }
        try {
            File file = new File(c.getFilesDir(), "college_user_accounts.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeMap<String, User> getUserAccounts() {
        return userAccounts;
    }

    public static void setUserAccounts(TreeMap<String, User> userAccounts) {
        UserManager.userAccounts = userAccounts;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserManager.currentUser = currentUser;
    }
}
