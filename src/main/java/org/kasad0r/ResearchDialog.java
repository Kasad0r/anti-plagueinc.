package org.kasad0r;

import org.kasad0r.researchs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResearchDialog extends JDialog {
    private final JLabel labelScoresInfo;
    private final JButton buttonDeathRes;
    private final JButton buttonQuarantineRes;
    private final JButton buttonRecoverRes;
    private final JButton buttonVaccineRes;
    private final JButton buttonBuyVentilators;
    private final JButton buttonDoubleMapPoints;
    private final JButton buttonExperimentalVaccine;
    private final JButton buttonMartialLaw;
    private final JButton buttonPatientMonitoring;
    private static final Font font = new Font("TimesRoman", Font.BOLD, 15);
    private static final DeathResearch deathResearch = new DeathResearch();
    private static final QuarantineResearch quarantineResearch = new QuarantineResearch();
    private static final RecoverResearch recoverResearch = new RecoverResearch();
    private static final VaccineResearch vaccineResearch = new VaccineResearch();
    private static final BuyVentilators buyVentilators = new BuyVentilators();
    private static final DoubleMapPointResearch doubleMapPointResearch = new DoubleMapPointResearch();
    private static final ExperimentalVaccineTesting experimentalVaccineTesting = new ExperimentalVaccineTesting();
    private static final MartialLawResearch martialLawResearch = new MartialLawResearch();
    private static final PatientMonitoringResearch patientMonitoringResearch = new PatientMonitoringResearch();

    static {
        deathResearch.cost = 15;
        quarantineResearch.cost = 10;
        recoverResearch.cost = 12;
        vaccineResearch.cost = 14;

    }

    public void updateData() {
        update();
        labelScoresInfo.setText("Research points:" + Game.currentPoints);
        labelScoresInfo.setIcon(StatisticsBar.icon);
    }


    public ResearchDialog() {
        buttonBuyVentilators = new JButton(buyVentilators.title + ": cost " + buyVentilators.cost);
        buttonDoubleMapPoints = new JButton(doubleMapPointResearch.title + ": cost " + doubleMapPointResearch.cost);
        buttonExperimentalVaccine = new JButton(experimentalVaccineTesting.title + ": cost " + experimentalVaccineTesting.cost);
        buttonMartialLaw = new JButton(martialLawResearch.title + ": cost " + martialLawResearch.cost);
        buttonPatientMonitoring = new JButton(patientMonitoringResearch.title + ": cost " + patientMonitoringResearch.cost);
        buttonDeathRes = new JButton("Slower death rate. cost: " + deathResearch.cost);
        buttonQuarantineRes = new JButton("Start quarantine. cost: " + quarantineResearch.cost);
        buttonRecoverRes = new JButton("People recover. cost: " + recoverResearch.cost);
        buttonVaccineRes = new JButton("Faster vaccine. cost: " + vaccineResearch.cost);
        buttonBuyVentilators.setFont(font);
        buttonDoubleMapPoints.setFont(font);
        buttonExperimentalVaccine.setFont(font);
        buttonMartialLaw.setFont(font);
        buttonPatientMonitoring.setFont(font);
        labelScoresInfo = new JLabel();
        labelScoresInfo.setIcon(StatisticsBar.icon);
        labelScoresInfo.setFont(font);
        labelScoresInfo.setText("Research points:" + Game.currentPoints);
        labelScoresInfo.setDisabledIcon(StatisticsBar.icon);
        JPanel contentPane = new JPanel();
        setTitle("Research");
        setContentPane(contentPane);
        setModal(true);
        contentPane.setLayout(new GridLayout(6, 1));

        buttonQuarantineRes.setFont(font);
        buttonRecoverRes.setFont(font);
        buttonVaccineRes.setFont(font);
        buttonDeathRes.setFont(font);
        contentPane.add(labelScoresInfo);
        getRootPane().setDefaultButton(buttonDeathRes);
        contentPane.add(buttonDeathRes);
        contentPane.add(buttonQuarantineRes);
        contentPane.add(buttonRecoverRes);
        contentPane.add(buttonVaccineRes);
        contentPane.add(buttonBuyVentilators);
        contentPane.add(buttonDoubleMapPoints);
        contentPane.add(buttonExperimentalVaccine);
        contentPane.add(buttonMartialLaw);
        contentPane.add(buttonPatientMonitoring);
        buttonDeathRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.currentPoints -= deathResearch.cost;
                deathResearch.activate();
                updateData();
            }
        });
        buttonQuarantineRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.currentPoints -= quarantineResearch.cost;
                quarantineResearch.activate();
                updateData();
            }
        });
        buttonRecoverRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.currentPoints -= recoverResearch.cost;
                recoverResearch.activate();
                updateData();
            }
        });
        buttonVaccineRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.currentPoints -= vaccineResearch.cost;
                vaccineResearch.activate();
                updateData();
            }
        });
        buttonBuyVentilators.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.currentPoints -= buyVentilators.cost;
                buyVentilators.activate();
                updateData();
            }
        });
        buttonDoubleMapPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.currentPoints -= doubleMapPointResearch.cost;
                doubleMapPointResearch.activate();
                updateData();
            }
        });
        buttonExperimentalVaccine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.currentPoints -= experimentalVaccineTesting.cost;
                experimentalVaccineTesting.activate();
                updateData();
            }
        });
        buttonMartialLaw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.currentPoints -= martialLawResearch.cost;
                martialLawResearch.activate();
                updateData();
            }
        });
        buttonPatientMonitoring.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.currentPoints -= patientMonitoringResearch.cost;
                patientMonitoringResearch.activate();
                updateData();
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void update() {
        buttonDeathRes.setEnabled(Game.currentPoints >= deathResearch.cost && deathResearch.isActive);
        buttonQuarantineRes.setEnabled(Game.currentPoints >= quarantineResearch.cost && quarantineResearch.isActive);
        buttonRecoverRes.setEnabled(Game.currentPoints >= recoverResearch.cost && recoverResearch.isActive);
        buttonVaccineRes.setEnabled(Game.currentPoints >= vaccineResearch.cost && vaccineResearch.isActive);
        buttonBuyVentilators.setEnabled(Game.currentPoints >= buyVentilators.cost && buyVentilators.isActive);
        buttonDoubleMapPoints.setEnabled(Game.currentPoints >= doubleMapPointResearch.cost && doubleMapPointResearch.isActive);
        buttonExperimentalVaccine.setEnabled(Game.currentPoints >= experimentalVaccineTesting.cost && experimentalVaccineTesting.isActive);
        buttonMartialLaw.setEnabled(Game.currentPoints >= martialLawResearch.cost && martialLawResearch.isActive);
        buttonPatientMonitoring.setEnabled(Game.currentPoints >= patientMonitoringResearch.cost && patientMonitoringResearch.isActive);
    }


}
