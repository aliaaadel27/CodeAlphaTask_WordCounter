import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WordCounter extends JFrame implements ActionListener {

    private final JLabel numberOfWords;
    private final JLabel heading;
    private final JTextArea textArea;
    private final JButton countWord;
    WordCounter(){
        super("Word Counter");
        numberOfWords=new JLabel("Number of words: ");
        numberOfWords.setBounds(50,300,200,50);
        numberOfWords.setForeground(Color.WHITE);

        heading=new JLabel("Write your paragraph here: ");
        heading.setBounds(50,0,200,50);
        heading.setForeground(Color.WHITE);

        textArea=new JTextArea();
        textArea.setBounds(50,50,350,200);


        countWord=new JButton("Count");
        countWord.setBounds(50,260, 80,30);
        countWord.setBackground(Color.LIGHT_GRAY);
        Font f = new Font("Serif", Font.BOLD, 15);
        countWord.setFont(f);

        countWord.addActionListener(this);

        getContentPane().setBackground(Color.darkGray);
        add(numberOfWords);
        add (countWord);
        add(textArea);
        add(heading);
        setSize(500,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==countWord){
            numberOfWords.setText("Number of words: "+ countWords());

        }
    }
    public static void main(String[] args){
        new WordCounter();
    }
    String countWords(){
        String text = textArea.getText().trim(); // Trim whitespace
        if (text.isEmpty()) {
            return "0";
        } else {
            String[] splittedParagraph = text.split("\\W+");
            long numberOfWords = Arrays.stream(splittedParagraph).count();
            return Long.toString(numberOfWords);
        }

    }
}








