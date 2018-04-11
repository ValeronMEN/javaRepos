package castle;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

public class Castle implements ActionListener {
    private float upperEyeLimit = 5.0f;
    private float lowerEyeLimit = 3.0f;

    private TransformGroup treeTransformGroup;
    private TransformGroup viewingTransformGroup;
    private Transform3D treeTransform3D = new Transform3D();
    private Transform3D viewingTransform = new Transform3D();
    private float angle = 0;
    private float eyeHeigth = upperEyeLimit;
    private boolean descend = true;

    public static void main(String[] args) {
        new Castle();
    }

    private Castle() {
        Timer timer = new Timer(50, this);
        SimpleUniverse universe = new SimpleUniverse();

        viewingTransformGroup = universe.getViewingPlatform().getViewPlatformTransform();
        universe.addBranchGraph(createSceneGraph());
        timer.start();
    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        // створюємо об'єкт, що будемо додавати до групи
        treeTransformGroup = new TransformGroup();
        treeTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        buildCastleSkeleton();
        objRoot.addChild(treeTransformGroup);

        Background background = new Background(new Color3f(1.0f, 1.0f, 1.0f)); // white color
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        objRoot.addChild(background);

        // налаштовуємо освітлення
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 0.5f, 0.4f);
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color,
                light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        // встановлюємо навколишнє освітлення
        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void buildCastleSkeleton() {
        Box body1 = CastleBody.getBody(0.125f, 1.0f);
        Transform3D body1T = new Transform3D();
        body1T.setTranslation(new Vector3f(.0f, .0f, .0f));
        TransformGroup body1TG = new TransformGroup();
        body1TG.setTransform(body1T);
        body1TG.addChild(body1);
        treeTransformGroup.addChild(body1TG);

        setFirstLevelTowers();

        Box body2 = CastleBody.getBody(0.125f, 0.6f);
        Transform3D body2T = new Transform3D();
        body2T.setTranslation(new Vector3f(.0f, .0f, 0.2f));
        TransformGroup body2TG = new TransformGroup();
        body2TG.setTransform(body2T);
        body2TG.addChild(body2);
        treeTransformGroup.addChild(body2TG);

        setSecondLevelTowers();

        Cylinder centralTower = CastleBody.getCentralTower();
        Transform3D centralTowerT = new Transform3D();
        centralTowerT.setTranslation(new Vector3f(.0f, .0f, 0.8f));
        centralTowerT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerTG = new TransformGroup();
        centralTowerTG.setTransform(centralTowerT);
        centralTowerTG.addChild(centralTower);
        treeTransformGroup.addChild(centralTowerTG);

        Cone centralTowerRoof = CastleBody.getCentralTowerRoof();
        Transform3D centralTowerRoofT = new Transform3D();
        centralTowerRoofT.setTranslation(new Vector3f(.0f, .0f, 1.4f));
        centralTowerRoofT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerRoofTG = new TransformGroup();
        centralTowerRoofTG.setTransform(centralTowerRoofT);
        centralTowerRoofTG.addChild(centralTowerRoof);
        treeTransformGroup.addChild(centralTowerRoofTG);
    }

    private void setFirstLevelTowers(){
        Box tower1 = CastleBody.getTower();
        Transform3D tower1T = new Transform3D();
        tower1T.setTranslation(new Vector3f(0.8f, 0.8f, 0.2f));
        TransformGroup tower1TG = new TransformGroup();
        tower1TG.setTransform(tower1T);
        tower1TG.addChild(tower1);
        treeTransformGroup.addChild(tower1TG);

        Box tower2 = CastleBody.getTower();
        Transform3D tower2T = new Transform3D();
        tower2T.setTranslation(new Vector3f(-0.8f, -0.8f, 0.2f));
        TransformGroup tower2TG = new TransformGroup();
        tower2TG.setTransform(tower2T);
        tower2TG.addChild(tower2);
        treeTransformGroup.addChild(tower2TG);

        Box tower3 = CastleBody.getTower();
        Transform3D tower3T = new Transform3D();
        tower3T.setTranslation(new Vector3f(0.8f, -0.8f, 0.2f));
        TransformGroup tower3TG = new TransformGroup();
        tower3TG.setTransform(tower3T);
        tower3TG.addChild(tower3);
        treeTransformGroup.addChild(tower3TG);

        Box tower4 = CastleBody.getTower();
        Transform3D tower4T = new Transform3D();
        tower4T.setTranslation(new Vector3f(-0.8f, 0.8f, 0.2f));
        TransformGroup tower4TG = new TransformGroup();
        tower4TG.setTransform(tower4T);
        tower4TG.addChild(tower4);
        treeTransformGroup.addChild(tower4TG);
    }

    private void setSecondLevelTowers(){
        Box tower1 = CastleBody.getTower();
        Transform3D tower1T = new Transform3D();
        tower1T.setTranslation(new Vector3f(0.4f, 0.4f, 0.4f));
        TransformGroup tower1TG = new TransformGroup();
        tower1TG.setTransform(tower1T);
        tower1TG.addChild(tower1);
        treeTransformGroup.addChild(tower1TG);

        Box tower2 = CastleBody.getTower();
        Transform3D tower2T = new Transform3D();
        tower2T.setTranslation(new Vector3f(-0.4f, -0.4f, 0.4f));
        TransformGroup tower2TG = new TransformGroup();
        tower2TG.setTransform(tower2T);
        tower2TG.addChild(tower2);
        treeTransformGroup.addChild(tower2TG);

        Box tower3 = CastleBody.getTower();
        Transform3D tower3T = new Transform3D();
        tower3T.setTranslation(new Vector3f(0.4f, -0.4f, 0.4f));
        TransformGroup tower3TG = new TransformGroup();
        tower3TG.setTransform(tower3T);
        tower3TG.addChild(tower3);
        treeTransformGroup.addChild(tower3TG);

        Box tower4 = CastleBody.getTower();
        Transform3D tower4T = new Transform3D();
        tower4T.setTranslation(new Vector3f(-0.4f, 0.4f, 0.4f));
        TransformGroup tower4TG = new TransformGroup();
        tower4TG.setTransform(tower4T);
        tower4TG.addChild(tower4);
        treeTransformGroup.addChild(tower4TG);
    }

    // ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // rotation of the castle
        treeTransform3D.rotZ(angle);
        treeTransformGroup.setTransform(treeTransform3D);
        angle += 0.05;

        // change of the camera position up and down within defined limits
        if (eyeHeigth > upperEyeLimit){
            descend = true;
        }else if(eyeHeigth < lowerEyeLimit){
            descend = false;
        }
        if (descend){
            eyeHeigth -= 0.05;
        }else{
            eyeHeigth += 0.05;
        }
        Point3d eye = new Point3d(5.0f, 5.0f, eyeHeigth); // spectator's eye
        Point3d center = new Point3d(.0f, .0f ,.0f); // sight target
        Vector3d up = new Vector3d(.0f, .0f, 1.0f);; // the camera frustum
        viewingTransform.lookAt(eye, center, up);
        viewingTransform.invert();
        viewingTransformGroup.setTransform(viewingTransform);
    }
}
