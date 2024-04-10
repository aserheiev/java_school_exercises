package pkg009_wetter;

public class Main {

    public static void main(String[] args)
    {
        int temp = -15;
        
        // alle mögliche Wetterzustände, die wie möchten
        enum Wetter 
        {
            Sonne,
            Regen,
            Schnee,
            Meteors
        }
        
        Wetter wetter = Wetter.Sonne;
        
        boolean rausGehen = false;
        boolean tanzen = false;
        
        if (temp >= -5) {
            // temp hoeher als -5
            if (temp == 17) {
                rausGehen = true;
                tanzen = true;
            } else {
                // nicht 17 und hoeher als -5
                if (temp <= 45) {
                    rausGehen = true;
                } else {
                    // temp hoeher als 45
                    if (temp > 60) {
                        // temp hoeher als 60
                        rausGehen = false;
                    } else {
                        // temp niedriger als 60 und hoeher als 45
                        if (wetter == Wetter.Sonne) {
                        rausGehen = false;
                        } else {
                            if (wetter == Wetter.Regen) {
                                rausGehen = true;
                                }
                        }
                    }
                }
            }
        } else {
            // temp niedriger als -5
                if (temp == - 17) {
                    rausGehen = true;
                    tanzen = true;
                }
                else {
                    // temp niedriger als -5 und ist nicht gibchen
                    if (temp < -18) {
                        rausGehen = false;
                    } else {
                        // temp niedriger als -5 aber hoeher als -18 und ist nicht -17
                        if (wetter == Wetter.Sonne) {
                            rausGehen = true;
                        }
                    }
                }
        }
                
        System.out.println("Raus gehen: " + rausGehen);
        System.out.println("Tanzen: " + tanzen);
               
    }
}