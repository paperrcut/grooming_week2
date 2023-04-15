package com.practice.week2.Serialization_Deserialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private int age;
    private String email;
    private String address;

    public static void saveUser(User user, String filePath)
    {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream objOut = new ObjectOutputStream(fos);
            objOut.writeObject(user);
            objOut.close();
            fos.close();
            System.out.println("User data saved to: "+filePath);
        }
        catch(IOException e)
        {
            System.out.println("Error saving user data: "+e.getMessage());
        }
    }

    public static User loadUser(String filePath)
    {
        User user = null;
        try{
            FileInputStream fos = new FileInputStream(filePath);
            ObjectInputStream objIn = new ObjectInputStream(fos);
            user = (User) objIn.readObject();
            objIn.close();
            fos.close();
            System.out.println("User data loaded from: "+filePath);
        }
        catch(IOException | ClassNotFoundException e )
        {
            System.out.println("Error loading user data: "+e.getMessage());
        }
        return user;
    }

    public static void main(String[] args)
    {
        User userSave = new User("Shivanshu",22, "shivanshu7777@gmail.com","Bareilly" );
        String filePath = "user1.dat";
        saveUser(userSave, filePath);

        User userLoad = loadUser(filePath);
        if(userLoad!=null)
        {
            System.out.println(userLoad);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
