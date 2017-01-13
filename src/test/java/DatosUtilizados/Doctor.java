package DatosUtilizados;

/**
 * Created by santiago on 1/12/17.
 */
public class Doctor {

    private Doctor(){

        char letters[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','i'};


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

    private static Doctor instance=null;


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


    public static Doctor generateDoctor(){
        if(instance==null){
            instance=new Doctor();
        }
        return instance;
    }

}
