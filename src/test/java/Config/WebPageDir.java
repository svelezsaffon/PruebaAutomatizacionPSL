package Config;

/**
 * Created by santiago on 1/12/17.
 */

public class WebPageDir {

    private static final String CENTRAL_URL="http://automatizacion.herokuapp.com/svelez/";

    public enum Pages {
        ANADIR_DOCTOR ("addDoctor"),
        ANADIR_PACIENTE ("addPatient"),
        ANADIR_HABITACION ("addRoom"),
        ANADIR_HOSPITAL ("addHospital"),
        AGENDAR_CITA ("appointmentScheduling");

        private final String name;

        private Pages(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because name.equals(null) returns false
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
    }


    public static String build_page(Pages page){
        StringBuilder url= new StringBuilder();

        url.append(CENTRAL_URL);


        url.append(page.toString());

        return url.toString();
    }



}
