package castle;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Primitive;

public class CastleBody {
    public static Box getBody(float height, float width) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(width, width, height, primflags, getBoxAppearence());
    }

    public static Box getTower() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.2f, 0.2f, 0.125f, primflags, getBoxAppearence());
    }

    public static Cylinder getCentralTower() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.2f, 1.0f, primflags, getBoxAppearence());
    }

    public static Cone getCentralTowerRoof() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.25f, 0.3f, primflags, getBoxAppearence());
    }

    private static Appearance getBoxAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(0.0f, 0.05f, 0.0f);
        Color3f ambient = new Color3f(0.2f, 0.5f, 0.15f);
        Color3f diffuse = new Color3f(0.2f, 0.15f, .15f);
        Color3f specular = new Color3f(0.0f, 0.8f, 0.0f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}