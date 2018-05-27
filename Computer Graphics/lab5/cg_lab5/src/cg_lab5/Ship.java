package cg_lab5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.vecmath.*;

public class Ship implements ActionListener, KeyListener {
    private Button go;
    private TransformGroup wholePlane;
    private Transform3D translateTransform;
    private Transform3D rotateTransformX;
    private Transform3D rotateTransformY;
    private Transform3D rotateTransformZ;
    
    private JFrame mainFrame;
    
    private float sign=1.0f;
    private float zoom=1f;
    private float xloc=0.0f;
    private float yloc=0.0f;
    private float zloc=0.0f;
    private int moveType=1;
    private Timer timer;
    private double angle = 0;
    
    public Ship(TransformGroup wholePlane, Transform3D trans,JFrame frame){
        go = new Button("Go");
        this.wholePlane=wholePlane;
        this.translateTransform=trans;
        this.mainFrame=frame;
        
        rotateTransformX= new Transform3D();
        rotateTransformY= new Transform3D();
        rotateTransformZ= new Transform3D();
        
        double rotAngl = Math.PI;
        rotateTransformY.rotY(rotAngl);
        translateTransform.mul(rotateTransformY);
        angle += rotAngl;
        
        Main.canvas.addKeyListener(this);
        timer = new Timer(100, this);
        
        Panel p =new Panel();
        p.add(go);
        mainFrame.add("North",p);
        go.addActionListener(this);
        go.addKeyListener(this);
    }

    private void initialPlaneState(){
        xloc=0.0f;
        yloc=0.0f;
        zloc=0.0f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // start timer when button is pressed
       if (e.getSource()==go){
          if (!timer.isRunning()) {
             timer.start();
             go.setLabel("Stop");
          }
          else {
              timer.stop();
              initialPlaneState();
              go.setLabel("Go");
          }
       }
       else {
           translateTransform.setScale(new Vector3d(zoom,zoom,zoom));
           translateTransform.setTranslation(new Vector3f(xloc,yloc,zloc));
           wholePlane.setTransform(translateTransform);
       }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
          //Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='s') {
            zloc = zloc + .1f;
            rotateTransformY.rotY(-angle);
            translateTransform.mul(rotateTransformY);
            angle = 0;
        }
        if (e.getKeyChar()=='w') {
            zloc = zloc - .1f;
            rotateTransformY.rotY(-angle);
            translateTransform.mul(rotateTransformY);
            angle = 0;
            
            double rotAngl = Math.PI;
            rotateTransformY.rotY(rotAngl);
            angle += rotAngl;
            translateTransform.mul(rotateTransformY);
        }
        if (e.getKeyChar()=='d') {
            xloc = xloc + .1f;
            rotateTransformY.rotY(-angle);
            translateTransform.mul(rotateTransformY);
            angle = 0;
            
            double rotAngl = Math.PI/2;
            rotateTransformY.rotY(rotAngl);
            angle += rotAngl;
            translateTransform.mul(rotateTransformY);
        }
        if (e.getKeyChar()=='a') {
            xloc = xloc - .1f;
            rotateTransformY.rotY(-angle);
            translateTransform.mul(rotateTransformY);
            angle = 0;
            
            double rotAngl = -Math.PI/2;
            rotateTransformY.rotY(rotAngl);
            angle += rotAngl;
            translateTransform.mul(rotateTransformY);
        }
        if (e.getKeyChar()=='r') {
            double rotAngl = Math.PI/6;
            rotateTransformY.rotY(rotAngl);
            translateTransform.mul(rotateTransformY);
            angle += rotAngl;
        }
        if (e.getKeyChar()=='t') {
            double rotAngl = -Math.PI/6;
            rotateTransformY.rotY(rotAngl);
            translateTransform.mul(rotateTransformY);
            angle += rotAngl;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }
}

