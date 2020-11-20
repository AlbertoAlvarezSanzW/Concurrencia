package sample;




public class Hilo extends Thread {
    public interface Callback{
        void updateText(Character character);
    }

    String texto;
    Callback callback;

    public Hilo(String texto, Callback callback){
        this.texto = texto;
        this.callback = callback;
    }



    @Override
    public void run() {
        for(int i = 0; i < texto.length(); i++) {
            try {
                Thread.sleep(1000);
                callback.updateText(texto.charAt(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
