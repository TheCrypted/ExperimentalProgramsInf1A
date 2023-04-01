package Entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected static float x;
    protected static float y;
    protected static int width, height;
    protected static Rectangle2D.Float hitbox;
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }
    protected void drawHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int)hitbox.x, (int)hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }
//    protected void updateHitbox(){
//        hitbox.x = (int)x;
//        hitbox.y = (int)y;
//    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}
