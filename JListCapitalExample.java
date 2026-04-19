/* Develop a Swing program in Java to add the countries USA, India, Vietnam,
Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore 
into a JList and display the capital of the countries on console whenever the 
countries are selected on the list. */

package Swings;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListCapitalExample extends JFrame {

private JList<String> countryList;
private HashMap<String, String> capitalMap;

public JListCapitalExample() {

// create country-capital mapping
capitalMap = new HashMap<>();
capitalMap.put("USA", "Washington D.C.");
capitalMap.put("India", "New Delhi");
capitalMap.put("Vietnam", "Hanoi");
capitalMap.put("Canada", "Ottawa");
capitalMap.put("Denmark", "Copenhagen");
capitalMap.put("France", "Paris");
capitalMap.put("Great Britain", "London");
capitalMap.put("Japan", "Tokyo");
capitalMap.put("Africa", "Addis Ababa");
capitalMap.put("Greenland", "Nuuk");
capitalMap.put("Singapore", "Singapore");

// create the model and add elements
DefaultListModel<String> listModel = new DefaultListModel<>();
listModel.addElement("USA");
listModel.addElement("India");
listModel.addElement("Vietnam");
listModel.addElement("Canada");
listModel.addElement("Denmark");
listModel.addElement("France");
listModel.addElement("Great Britain");
listModel.addElement("Japan");
listModel.addElement("Africa");
listModel.addElement("Greenland");
listModel.addElement("Singapore");

// create the list
countryList = new JList<>(listModel);

countryList.addListSelectionListener(new ListSelectionListener() {
@Override
public void valueChanged(ListSelectionEvent e) {
if (!e.getValueIsAdjusting()) {
List<String> selected = countryList.getSelectedValuesList();

for (String country : selected) {
String capital = capitalMap.get(country);
System.out.println("Capital of " + country + " is: " + capital);
}
}
}
});

add(new JScrollPane(countryList));

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("Country Capitals");
this.setSize(250, 250);
this.setLocationRelativeTo(null);
this.setVisible(true);
}

public static void main(String[] args) {
new JListCapitalExample();
}
}
