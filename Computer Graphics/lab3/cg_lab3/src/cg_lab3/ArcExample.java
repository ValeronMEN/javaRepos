package cg_lab3;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.stage.Stage; 
import javafx.scene.shape.Arc;  
import javafx.scene.shape.ArcType; 
        
public class ArcExample extends Application { 
   @Override 
   public void start(Stage stage) { 
      //Drawing an arc 
      Arc arc = new Arc(); 
         
      //Setting the properties of the arc 
      arc.setCenterX(300.0f); 
      arc.setCenterY(150.0f); 
      arc.setRadiusX(90.0f); 
      arc.setRadiusY(90.0f); 
      arc.setStartAngle(40.0f); 
      arc.setLength(239.0f);  
      
      //Setting the type of the arc 
      arc.setType(ArcType.OPEN);         
         
      //Creating a Group object  
      Group root = new Group(arc); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Drawing an Arc"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage
      stage.show(); 
   }   
   public static void main(String args[]){ 
      launch(args); 
   } 
}