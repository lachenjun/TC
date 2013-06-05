package SRM203.D2L1.V250;

public class UserName {

    public static String newMember(String[] existingNames, String newName) {
        boolean found = false;
        int number = 0;
        String retName = newName;
        do {
            found = false;
            for (String name : existingNames) {
                if (name.equals(retName)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                number++;
                retName = newName + number;
            }
        } while (found);
        return retName;
    }

    public static void main(String[] args) {
        System.out.println(newMember(new String[] { "MasterOfDisaster",
                "TygerTyger1", "DingBat", "Orpheus", "TygerTyger", "WolfMan",
                "MrKnowItAll" }, "TygerTyger"));
    }
}
