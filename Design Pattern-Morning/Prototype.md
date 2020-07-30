# Prototype Design Pattern Analysis 

Prototype patterns refers to creating duplicate objects while keeping heavy and smooth performance in mind i.e it lets you copy existing objects without making your code dependent on their classes. 


> It comes under creational pattern because it provides one of the best ways to create an object which is heavily used in the recent times.


## Let's see the problem ;)  

Consider you have an object, and you want to create an exact copy of this object. So, at first you will create a new object of the same class. Then you have to overlook to all the fields of the original object and copy its value to the created new object.

>Great! But... just pay attention here that there could be some of the object's fields which can't be allowed outside of the class due to limitation of its visibility which occurs due to its private nature, result of which leads to the accessing problem. 

![Prototype always doesn't provide expected result](https://drive.google.com/uc?export=view&id=1FrEHu-E4wEP_cyI2vvcDYQlb5nj1Dg6O)


## Solution :)
### An approach using Clone method


One of the best available way to create object from existing objects are clone() method. Clone is the simplest approach to implement prototype pattern. However, it is your call to decide how to copy existing object based on your business model.The implementation of the clone method is very similar in all classes. The method creates an object of the current class and carries over all of the field values of the old object into the new one. You can even copy private fields because most programming languages let objects access private fields of other objects that belong to the same class.

#### Prototype Design Participants

* Prototype : It is just a prototype of real object.

* Prototype registry : It is used as registry service to have all prototypes accessible.
* Client : Client will be responsible for using registry service to access prototype instances.

**An object that supports cloning is called a prototype.** 
When objects have several fields and different possible configurations, cloning them leads to subclassing.

***

### Implementation 
##### Cosider an example where we are going to an abstract class Shape and concrete classes extending the Shape class. A class ShapeCache is defined as a next step which stores shape objects in a Hashtable and returns their clone when requested.

Consider PrototypPatternDemo, our demo class will use ShapeCache class to get a Shape object.

![Example of UML diagram prototype pattern](https://drive.google.com/uc?export=view&id=11vVmygLipSeLeGxGfFDKn9xLMxPE6qNw)

#### Step 1

Create an abstract class implementing Clonable interface.

> Shape.java

```Java
public abstract class Shape implements Cloneable {
   
   private String id;
   protected String type;
   
   abstract void draw();
   
   public String getType(){
      return type;
   }
   
   public String getId() {
      return id;
   }
   
   public void setId(String id) {
      this.id = id;
   }
   
   public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
}
```

#### Step 2

Create concrete classes extending the above class.

> Rectangle.java


```Java
public class Rectangle extends Shape {

   public Rectangle(){
     type = "Rectangle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
```

> Square.java

```Java
public class Square extends Shape {

   public Square(){
     type = "Square";
   }

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}
```
>Circle.java

```Java
public class Circle extends Shape {

   public Circle(){
     type = "Circle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}
```
#### Step 3
Create a class to get concrete classes from database and store them in a Hashtable.

> ShapeCache.java


```Java
import java.util.Hashtable;
public class ShapeCache {
	
   private static Hashtable<String, Shape> shapeMap  = new Hashtable<String, Shape>();

   public static Shape getShape(String shapeId) {
      Shape cachedShape = shapeMap.get(shapeId);
      return (Shape) cachedShape.clone();
   }

   // for each shape run database query and create shape
   // shapeMap.put(shapeKey, shape);
   // for example, we are adding three shapes
   
   public static void loadCache() {
      Circle circle = new Circle();
      circle.setId("1");
      shapeMap.put(circle.getId(),circle);

      Square square = new Square();
      square.setId("2");
      shapeMap.put(square.getId(),square);

      Rectangle rectangle = new Rectangle();
      rectangle.setId("3");
      shapeMap.put(rectangle.getId(), rectangle);
   }
}
```

#### Stpe 4

PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a Hashtable.

> PrototypePatternDemo.java

```Java

public class PrototypePatternDemo {
   public static void main(String[] args) {
      ShapeCache.loadCache();

      Shape clonedShape = (Shape) ShapeCache.getShape("1");
      System.out.println("Shape : " + clonedShape.getType());		

      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
      System.out.println("Shape : " + clonedShape2.getType());		

      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
      System.out.println("Shape : " + clonedShape3.getType());		
   }
}
```

#### Step Final

>***Check the output***

***
## Applicability

* Applicability
 Use the Prototype pattern when your code shouldn’t depend on the concrete classes of objects that you need to copy.

 * This happens a lot when your code works with objects passed to you from 3rd-party code via some interface. The concrete classes of these objects are unknown, and you couldn’t depend on them even if you wanted to.

* The Prototype pattern provides the client code with a general interface for working with all objects that support cloning. This interface makes the client code independent from the concrete classes of objects that it clones.

 * The Prototype pattern lets you use a set of pre-built objects, configured in various ways, as prototypes.

 * Instead of instantiating a subclass that matches some configuration, the client can simply look for an appropriate prototype and clone it.

***

### Pros  

    * You can clone objects without coupling to their concrete classes.
    * You can get rid of repeated initialization code in favor of cloning pre-built prototypes.
    * You can produce complex objects more conveniently.
    * You get an alternative to inheritance when dealing with configuration presets for complex objects.
 

 ### Cons 

    * Cloning complex objects that have circular references might be very tricky.
 
##### Links for the Analysis of Prototype Design Pattern

[Link 1](targetURL "https://en.wikipedia.org/wiki/Prototype_pattern#:~:text=The%20prototype%20pattern%20is%20a,cloned%20to%20produce%20new%20objects.")

[Link 2](targetURL "https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm")

[Link 3](tragetURL "https://www.geeksforgeeks.org/prototype-design-pattern/")

[Link 4](tragetURL "https://refactoring.guru/design-patterns/prototype")

[Link 5](tragetURL "https://sourcemaking.com/design_patterns")