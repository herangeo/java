interface GymAction {
    String performAction(String member);
}
public interface GymMember {
    int MemberId(int Id);
}

public class GymLambdaaApp {
    public static void main(String[] args) {

        GymAction welcomeMember = (member) -> "Welcome to the gym, " + member + "!";
        GymAction checkInMember = (member) -> member + " has checked in.";
        GymMember CheckId =(Id)->Id;


        System.out.println(welcomeMember.performAction("hiran"));
        System.out.println(checkInMember.performAction("hiran"));
        System.out.println(CheckId.MemberId(18));

    }
}