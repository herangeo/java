// Generic interface for gym activities
interface GymActivity<T> {
    void performActivity(T activity);
}

// Generic class for gym equipment
class GymEquipment<T> implements GymActivity<T> {
    private T equipmentName;

    GymEquipment(T equipmentName) {
        this.equipmentName = equipmentName;
    }

    public T getEquipmentName() {
        return this.equipmentName;
    }

    @Override
    public void performActivity(T activity) {
        System.out.println("Using " + equipmentName + " for " + activity);
    }
}

// Generic class for gym members
class GymMember<T> {
    private T memberInfo;

    GymMember(T memberInfo) {
        this.memberInfo = memberInfo;
    }

    public T getMemberInfo() {
        return this.memberInfo;
    }
}

// Driver class to test above
public class GymManagementSystem {
    public static void main(String[] args) {
        // Using GymEquipment with String type (equipment name)
        GymEquipment<String> treadmill = new GymEquipment<>("Treadmill");
        System.out.println("Equipment Name: " + treadmill.getEquipmentName());
        treadmill.performActivity("running");

        // Using GymEquipment with Integer type (equipment ID)
        // Using GymEquipment with Integer type (equipment ID)
        GymEquipment<Integer> dumbbells = new GymEquipment<>(101);
        System.out.println("Equipment ID: " + dumbbells.getEquipmentName());
        dumbbells.performActivity(50); // Use an Integer argument, e.g., weight in kilograms


        // Using GymMember with String type (member name)
        GymMember<String> member1 = new GymMember<>("John Doe");
        System.out.println("Member Name: " + member1.getMemberInfo());

        // Using GymMember with Integer type (member ID)
        GymMember<Integer> member2 = new GymMember<>(1001);
        System.out.println("Member ID: " + member2.getMemberInfo());
    }
}
