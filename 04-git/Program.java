//Java Program to illustrate how to define a class and fields  
//Defining a Student class. 
//Students can only drink for now but they do that frequently 
class Student{  
 //defining fields  
 int id;//field or data member or instance variable 
 int hunger; 
 String name;  
 //creating main method inside the Student class  
 public static void main(String args[]){  
  //Creating an object or instance  
  Student s1=new Student();//creating an object of Student  
  //Printing values of the object  
  System.out.println(s1.id);//accessing member through reference variable  
  System.out.println(s1.name);  
 }  

 public static void drink(int Liters){
    Str beerType = "Lager";
    System.out.println("Drinking... " + Liters + " of beer");
    System.out.println("Because it was a Lager the student ended up");
    System.out.println("Dead drunk");
    this = null;
 }

 public static void eat(Str food){
   System.out.println("Eating..." + food);
   this.hunger -= 100;
 }

 public int identifyYourself(){
   return this.id
 }
}  