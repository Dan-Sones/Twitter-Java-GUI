// import twitter stuff
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import swing stuff
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;

//main class
public class main implements ActionListener {
    //set up elements
    private static JLabel title;
    private static JTextField Userinput;
    private static JButton PressToTweet;
    private static JLabel Tweeted;

    //main method
    public static void main(String[] args) {
        //Setup Panel
        JPanel panel = new JPanel();
        //Setup frame
        JFrame frame = new JFrame();
        //Set the frame size
        frame.setSize(250, 200);
        //Make the frame un-resizeable
        frame.setResizable(false);
        //When X is pressed to close then close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add the panel to the frame
        frame.add(panel);

        // Panel stuff
        panel.setLayout(null);

        //Setup label
        title = new JLabel("What do you want to tweet?");
        title.setBounds(10, 20, 300, 25);
        panel.add(title);

        //setup text box
        Userinput = new JTextField();
        Userinput.setBounds(10, 50, 165, 25);
        panel.add(Userinput);

        //Setup Button
        PressToTweet = new JButton("Tweet!");
        PressToTweet.setBounds(10, 80, 80, 25);
        PressToTweet.addActionListener(new main());
        panel.add(PressToTweet);

        //setup label
        Tweeted = new JLabel("");
        Tweeted.setBounds(10, 110, 300, 25);
        panel.add(Tweeted);

        frame.setVisible(true);
    }//main

    @Override
    public void actionPerformed(ActionEvent e) { //On button action
        //Setup twitter
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                // [--------------------------------------- ENTER YOUR TWITTER API DETAILS HERE ---------------------------------------]
                .setOAuthConsumerKey("FILL ME IN")
                .setOAuthConsumerSecret("FILL ME IN")
                .setOAuthAccessToken("FILL ME IN")
                .setOAuthAccessTokenSecret("FILL ME IN");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();


        // maincode
        String Tweetcontents = Userinput.getText();

        try {
            twitter.updateStatus(Tweetcontents);
            Tweeted.setText("You Just Tweeted '" + Tweetcontents + "' ");

        } catch (TwitterException twitterException) {
            twitterException.printStackTrace();
        }


    }//listener
}//class