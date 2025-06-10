import java.util.Scanner;
import java.io.File;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * The TreePane4 class extends StackPane and is responsible for creating a TreeView
 * that displays customer information categorized by credit card type and expiration year.
 */
public class TreePane4 extends StackPane {

    // Icons for the tree nodes
    private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("folder.png")));
    private final Image peopleIcon = new Image(getClass().getResourceAsStream("people.png"));
    private final Image visaIcon = new Image(getClass().getResourceAsStream("Visa.png"));
    private final Image mcIcon = new Image(getClass().getResourceAsStream("MasterCard.png"));

    // Number of test customers
    private static final int TEST_COUNT = 25;

    // Array to hold customer objects
    private Customer[] customers = new Customer[TEST_COUNT];    

    // Root item for the tree
    private TreeItem<String> rootItem = new TreeItem<>("Customers", rootIcon);
    private TreeItem<String> CCExpireNode;
    private TreeItem<String> CCTypeNode;
    private TreeView<String> tree;

    /**
     * Constructor for TreePane4. Initializes the tree view and loads customer data.
     */
    public TreePane4() {
        // Load customer data into the array
        loadArray();

        // Set the root item to be expanded by default
        rootItem.setExpanded(true);
        String expireYear = "";

        // Iterate through the customers and organize them into the tree
        for (Customer customer : customers) {
            if (customer == null) {
            System.out.println("Null customer found, skipping...");
            continue;
        }
            TreeItem<String> customerLeaf = new TreeItem<>(customer.getFullName());
            boolean foundCC = false;
            boolean foundCCExpire = false;
            expireYear = customer.getCreditCardExpiration().substring(customer.getCreditCardExpiration().length() - 4);

            // Check if the credit card type node already exists
            for (TreeItem<String> CCTypeNode : rootItem.getChildren()) {
                if (CCTypeNode.getValue().contentEquals(customer.getCreditCardType())) {
                    // Check if the expiration year node already exists
                    for (TreeItem<String> CCExpireNode : CCTypeNode.getChildren()) {
                        String nodeExpireYear = CCExpireNode.getValue().substring(CCExpireNode.getValue().length() - 4);
                        if (nodeExpireYear.contentEquals(expireYear)) {
                            CCExpireNode.getChildren().add(customerLeaf);
                            foundCC = true;
                            foundCCExpire = true;
                            break;
                        }
                    }
                    if (!foundCCExpire) {
                        CCExpireNode = new TreeItem<>(expireYear, new ImageView(peopleIcon));
                        CCTypeNode.getChildren().add(CCExpireNode);
                        CCExpireNode.getChildren().add(customerLeaf);
                        foundCC = true;
                        break;
                    }
                }
            }

            // If the credit card type node does not exist, create it
            if (!foundCC) {
                if (customer.getCreditCardType().equals("Visa"))
                    CCTypeNode = new TreeItem<>(customer.getCreditCardType(), new ImageView(visaIcon));
                else
                    CCTypeNode = new TreeItem<>(customer.getCreditCardType(), new ImageView(mcIcon));
                rootItem.getChildren().add(CCTypeNode);
                CCExpireNode = new TreeItem<>(expireYear, new ImageView(peopleIcon));
                CCTypeNode.getChildren().add(CCExpireNode);
                CCExpireNode.getChildren().add(customerLeaf);
            }
        }

        // Create the tree view with the root item
        tree = new TreeView<>(rootItem);
        getChildren().add(tree);
    }

    /**
     * Loads customer data from a CSV file into the customers array.
     */
    public void loadArray() {
        try {
            File file = new File("Customers.csv");
            Scanner fileScan = new Scanner(file);
            String recordScan = "";

            String SSN;
            char gender;
            String firstName;
            String middleInitial;
            String lastName;
            String street;
            String city;
            String state;
            String zipcode;
            String birthdate;
            String creditCardType;
            String creditCardNumber;
            String creditCardExpiration;
            int count = 0;

             // Read each line from the CSV file and create Customer objects
        while (fileScan.hasNextLine() && count < TEST_COUNT) {
            recordScan = fileScan.nextLine();
            Scanner lineScan = new Scanner(recordScan);
            lineScan.useDelimiter(",");

            if (lineScan.hasNext()) {
                SSN = lineScan.next();
                gender = lineScan.next().charAt(0);
                firstName = lineScan.next();
                middleInitial = lineScan.next();
                lastName = lineScan.next();
                street = lineScan.next();
                city = lineScan.next();
                state = lineScan.next();
                zipcode = lineScan.next();
                birthdate = lineScan.next();
                creditCardType = lineScan.next();
                creditCardNumber = lineScan.next();
                creditCardExpiration = lineScan.next();

                customers[count] = new Customer(SSN, gender, firstName, middleInitial, 
                                                lastName, street, city, state, zipcode, birthdate, 
                                                creditCardType, creditCardNumber, 
                                                creditCardExpiration);
                count++;
            } else {
                System.out.println("Empty or malformed line in CSV file, skipping...");
            }
        }

        System.out.println("Loaded " + count + " customers.");
    } catch (Exception exception) {
        exception.printStackTrace();
    }
}
}
