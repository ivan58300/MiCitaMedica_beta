import java.util.ConcurrentModificationException;

import static ui.UIMenu.mostrarMenu;

public class Main {
    public void main(String[] args) {
        try{
            mostrarMenu();
        }catch (ConcurrentModificationException e){
        }

        //Prueba2
    }
}
