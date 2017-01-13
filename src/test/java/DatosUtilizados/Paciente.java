package DatosUtilizados;

/**
 * Created by santiago on 1/12/17.
 */
public class Paciente {

    private Paciente(){

        char letters[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','i'};


        if((int)(Math.random() * 10) % 2==0){
            this.prepagada=true;
        }else{
            this.prepagada=false;
        }

        for(int i=0;i<10;i++){
            int random= (int)(Math.random() * letters.length);
            this.name+=letters[random];
        }

        for(int i=0;i<10;i++){
            int random= (int)(Math.random() * letters.length);
            this.lastName+=letters[random];
        }

        for(int i=0;i<10;i++){
            int random= (int)(Math.random() * 10);
            this.tel+=random;
        }

        for(int i=0;i<10;i++){
            int random= (int)(Math.random() * 10);
            this.id+=random;
        }
    }

    private String name="";

    private String tel="";

    private String id="";

    private String lastName="";

    private boolean prepagada;

    private static Paciente instance=null;

    public boolean getPrepa(){
        return this.prepagada;
    }


    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getId(){
        return this.id;
    }

    public String getTel(){
        return this.tel;
    }


    public static Paciente generatePaciente(){
        if(instance==null){
            instance=new Paciente();
        }
        return instance;
    }


}
