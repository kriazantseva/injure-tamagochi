package project.gui;

import project.enums.items.food.FoodItems;
import project.enums.items.food.WaterItem;
import project.enums.items.food.treats.FoodTreatsForCats;
import project.enums.items.toys.ToysForCats;
import project.enums.mood.MoodGenerator;
import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;
import project.enums.pets.pet_model.PetCat;
import project.enums.pets.pet_model.PetModel;
import project.service.PetSimulator;
import project.service.SleepService;
import project.service.feeding.FeedingService;
import project.service.feeding.treating.TreatForCatService;
import project.service.toy_play.ToyForCatService;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
* Simple GUI class for quick visualisation and checking dependencies
*/
public class PetSimulatorGui {
    private JFrame frame;
    private JLabel hungerLabel;
    private JLabel thirstLabel;
    private JLabel energyLabel;
    private JLabel wellbeingLabel;
    private JLabel mood;
    private PetCat petModel;
    private JComboBox<FoodItems> foodComboBox;
    private JComboBox<WaterItem> waterComboBox;
    private JComboBox<ToysForCats> toyComboBox;
    private JComboBox<FoodTreatsForCats> treatComboBox;
    private final PetSimulator petSimulator;
    private final FeedingService feedingService;
    private TreatForCatService treatForCatService;
    private ToyForCatService toyForCatService;
    private final SleepService sleepService;
    private final MoodGenerator moodGenerator;

    private JTextField petNameField;
    private JComboBox<PetType> petTypeComboBox;
    private JComboBox<LevelOfPets> levelComboBox;

    public PetSimulatorGui() {
        this.moodGenerator = new MoodGenerator();
        this.petSimulator = new PetSimulator(moodGenerator);
        this.feedingService = new FeedingService(moodGenerator);
        this.sleepService = new SleepService();
    }

    public void show() {
        frame = new JFrame("Pet Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Panel for selecting pet
        JPanel petSelectionPanel = new JPanel(new GridLayout(5, 2));
        petNameField = new JTextField();
        petTypeComboBox = new JComboBox<>(PetType.values());
        levelComboBox = new JComboBox<>(LevelOfPets.values());

        JButton createPetButton = new JButton("Create Pet");
        createPetButton.addActionListener(e -> createPet());

        petSelectionPanel.add(new JLabel("Pet Name:"));
        petSelectionPanel.add(petNameField);
        petSelectionPanel.add(new JLabel("Pet Type:"));
        petSelectionPanel.add(petTypeComboBox);
        petSelectionPanel.add(new JLabel("Level:"));
        petSelectionPanel.add(levelComboBox);
        petSelectionPanel.add(new JLabel()); // Empty cell for layout
        petSelectionPanel.add(createPetButton);

        frame.add(petSelectionPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void createPet() {
        String petName = petNameField.getText();
        PetType petType = (PetType) petTypeComboBox.getSelectedItem();
        LevelOfPets level = (LevelOfPets) levelComboBox.getSelectedItem();

        // Initialize PetModel and related services
        petModel = new PetCat(level, petType);
        petModel.setPetName(petName);
        toyForCatService = new ToyForCatService(ToysForCats.class, petModel);
        treatForCatService = new TreatForCatService(FoodTreatsForCats.class, petModel);

        // Switch to simulation panel
        frame.getContentPane().removeAll();
        initializeSimulationPanel();
    }

    private void initializeSimulationPanel() {
        JPanel statusPanel = new JPanel(new GridLayout(5, 2));
        hungerLabel = new JLabel("Hunger: " + petSimulator.getHungerStatus());
        thirstLabel = new JLabel("Thirst: " + petSimulator.getThirstStatus());
        energyLabel = new JLabel("Energy: " + petSimulator.getEnergyStatus());
        wellbeingLabel = new JLabel("Well-Being: " + petSimulator.getWellBeingStatus());
        mood = new JLabel("Mood: " + moodGenerator.getMoodMap());

        statusPanel.add(new JLabel("Hunger:"));
        statusPanel.add(hungerLabel);
        statusPanel.add(new JLabel("Thirst:"));
        statusPanel.add(thirstLabel);
        statusPanel.add(new JLabel("Energy:"));
        statusPanel.add(energyLabel);
        statusPanel.add(new JLabel("Well-Being:"));
        statusPanel.add(wellbeingLabel);
        statusPanel.add(new JLabel("Mood: "));
        statusPanel.add(mood);

        frame.add(statusPanel, BorderLayout.NORTH);

        // Panel for Item Selection and Interaction Buttons
        JPanel selectionPanel = new JPanel(new GridLayout(5, 2));

        foodComboBox = new JComboBox<>(FoodItems.values());
        waterComboBox = new JComboBox<>(WaterItem.values());
        toyComboBox = new JComboBox<>(ToysForCats.values());
        treatComboBox = new JComboBox<>(FoodTreatsForCats.values());

        JButton feedButton = new JButton("Feed");
        feedButton.addActionListener(e -> feedingService.feeding((FoodItems) foodComboBox.getSelectedItem()));

        JButton giveWaterButton = new JButton("Give Water");
        giveWaterButton.addActionListener(e -> feedingService.giveWater((WaterItem) waterComboBox.getSelectedItem()));

        JButton playButton = new JButton("Play with Toy");
        playButton.addActionListener(e -> toyForCatService.giveToy((ToysForCats) toyComboBox.getSelectedItem(),
                petSimulator.getWellBeingStatus(), null, moodGenerator));

        JButton giveTreatButton = new JButton("Give Treat");
        giveTreatButton.addActionListener(e -> treatForCatService.giveTreat((FoodTreatsForCats) treatComboBox.getSelectedItem(),
                petSimulator.getWellBeingStatus(), null, moodGenerator));

        JButton takeANapButton = new JButton("Take a Nap");
        takeANapButton.addActionListener(e -> sleepService.takeNap());

        selectionPanel.add(new JLabel("Select Food:"));
        selectionPanel.add(foodComboBox);
        selectionPanel.add(feedButton);

        selectionPanel.add(new JLabel("Select Water:"));
        selectionPanel.add(waterComboBox);
        selectionPanel.add(giveWaterButton);

        selectionPanel.add(new JLabel("Take A Nap!"));
        selectionPanel.add(new JLabel("......"));
        selectionPanel.add(takeANapButton);

        selectionPanel.add(new JLabel("Select Toy:"));
        selectionPanel.add(toyComboBox);
        selectionPanel.add(playButton);

        selectionPanel.add(new JLabel("Select Treat:"));
        selectionPanel.add(treatComboBox);
        selectionPanel.add(giveTreatButton);

        frame.add(selectionPanel, BorderLayout.CENTER);

        // Start simulation
        frame.setVisible(true);
        startSimulation();
    }

    private void startSimulation() {
        petSimulator.simulate(petModel.getLevel());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateIndicators();
                if (petSimulator.isDead()) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(frame, "Your pet has reached critical levels.");
                    frame.dispose();
                }
            }
        }, 0, 500);
    }

    private void updateIndicators() {
        hungerLabel.setText("Hunger: " + petSimulator.getHungerStatus());
        thirstLabel.setText("Thirst: " + petSimulator.getThirstStatus());
        energyLabel.setText("Energy: " + petSimulator.getEnergyStatus());
        wellbeingLabel.setText("Well-Being: " + petSimulator.getWellBeingStatus());
        mood.setText("Mood: " + moodGenerator.getMoodMap());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetSimulatorGui().show());
    }
}
