package com.pgs.javadev;

/**
 * Created by iwona on 28.04.16.
 */
public class studentsANDgrades
{
    int id;
    String name;
    String surname;

    public studentsANDgrades(int id, String name, String surname)
    {
        this.id=id;
        this.name = name;
        this.surname = surname;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getGrade()
    {
        return grades;
    }

    String grades=new String();

    public boolean setGrade(int setting_grade)
    {
        if(setting_grade < 1 || setting_grade > 6)
            return false;
        this.grades +=String.valueOf(setting_grade)+" ";
        return true;
    }

    @Override
    public String toString()
    {
        return "ID: "+id+" | name: "+name+" | surname: "+surname+" | grades: "+grades+" \n";
    }
}
