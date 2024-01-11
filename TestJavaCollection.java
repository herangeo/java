import java.util.*;

class TestJavaCollection {
    public static void main(String args[]) {
        // Creating ArrayList for gym members
        ArrayList<String> gymMember = new ArrayList<>();
        gymMember.add("Ravi");
        gymMember.add("Vijay");
        gymMember.add("Ravi");
        gymMember.add("Ajay");

        // Generating personal IDs for each member using HashMap
        HashMap<String, String> personalIdsHashMap = new HashMap<>();
        int memberIdCounterHashMap = 0;

        for (String member : gymMember) {
            String personalId = "ID" + memberIdCounterHashMap++;
            personalIdsHashMap.put(member, personalId);
        }

        // **Adding a HashSet to track active memberships**
        HashSet<String> activeMemberships = new HashSet<>();
        activeMemberships.add("Ravi");
        activeMemberships.add("Ajay");

        System.out.println("\nPersonal IDs for each member (HashMap):");
        for (Map.Entry<String, String> entry : personalIdsHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nActive memberships (HashSet):");
        for (String activeMember : activeMemberships) {
            System.out.println(activeMember);
        }
    }
}
