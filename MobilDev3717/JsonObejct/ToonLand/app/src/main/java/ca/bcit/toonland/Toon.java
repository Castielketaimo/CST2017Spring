package ca.bcit.toonland;

/**
 * Created by A00127241 on 2017-10-01.
 */

public class Toon
{
    private int PersonId;

    private String FirstName;

    private String LastName;

    private String Occupation;

    private String Gender;

    private String Created;

    private String Picture;

    public void setPersonId(int PersonId){
        this.PersonId = PersonId;
    }
    public int getPersonId(){
        return this.PersonId;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public String getFirstName(){
        return this.FirstName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    public String getLastName(){
        return this.LastName;
    }
    public void setOccupation(String Occupation){
        this.Occupation = Occupation;
    }
    public String getOccupation(){
        return this.Occupation;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    public String getGender(){
        return this.Gender;
    }
    public void setCreated(String Created){
        this.Created = Created;
    }
    public String getCreated(){
        return this.Created;
    }
    public void setPicture(String Picture){
        this.Picture = Picture;
    }
    public String getPicture(){
        return this.Picture;
    }
}
