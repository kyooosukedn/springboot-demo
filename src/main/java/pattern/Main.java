package pattern;

import javax.swing.JButton;
import javax.swing.JWindow;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

class Main {
    public static void main(String[] args) {
        ButtonWindow window = new ButtonWindow();
        window.setVisible(true);

        window.addButtonClickListener(() -> System.out.println("Button clicked"));
    }
}

// Observer interface for receiving button click events
interface ButtonClickListener {
    void onButtonClick();
}

// Implements ButtonObservable that represents the button
class ButtonObservable extends Observable {
    public void notifyButtonClick() {
        setChanged();
        notifyObservers();
    }
}

// Observer class that receives button click events
class ButtonClickObserver implements Observer {
    private ButtonClickListener listener;

    public ButtonClickObserver(ButtonClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void update(Observable o, Object arg) {
        listener.onButtonClick();
    }
}

class ButtonWindow extends Frame {
    private ButtonObservable btnObservable;

    public ButtonWindow() {
        btnObservable = new ButtonObservable();

        Button btn = new Button("Click");
        btn.addActionListener(e -> btnObservable.notifyButtonClick());
        add(btn);
        pack();

        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void addButtonClickListener(ButtonClickListener listener) {
        btnObservable.addObserver(new ButtonClickObserver(listener));
    }


}
