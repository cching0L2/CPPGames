import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class KeyboardControl extends JPanel{
 
    private static final long serialVersionUID = 4122465017629656635L;
    static private Direction prevDir = null;

    KeyboardControl(){
        KeyListener listener = new getKeyInput();
        addKeyListener(listener);
        setFocusable(true);
    }
    
    static public Direction getPrevDir(){
        return prevDir;
    }
    
    public class getKeyInput implements KeyListener{
        private final int LEFT_KEY = 37;
        private final int UP_KEY = 38;
        private final int RIGHT_KEY = 39;
        private final int DOWN_KEY = 40;
        
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("key pressed: "+KeyEvent.getKeyText(e.getKeyCode())+"  "+e.getKeyCode());
            int keyCode = e.getKeyCode();
            Direction direction = null;
            
            switch(keyCode){
            case(LEFT_KEY):
                direction = Direction.LEFT;
                break;
            case(RIGHT_KEY):
                direction = Direction.RIGHT;
                break;
            case(UP_KEY):
                direction = Direction.UP;
                break;
            case(DOWN_KEY):
                direction = Direction.DOWN;
                break;
            }
           
            if(!Snake.hitWall() && !Snake.hitSelf() && !(prevDir==direction))
                Snake.move(direction);
            prevDir = direction;
        }

        @Override
        public void keyReleased(KeyEvent e) {} 
    }
}