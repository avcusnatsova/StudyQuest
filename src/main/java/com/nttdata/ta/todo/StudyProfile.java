package com.nttdata.ta.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int totalXP;
    private int level;

    private int currentStreak;
    private int longestStreak;

    private int monthlyTasksCompleted;
    private int monthlyXP;
    private int monthlyGoal;

    // Tracks which month the monthly progress belongs to
    private String monthlyPeriod;

    // Study Goal
    private String studyGoal;
    private int goalTarget;
    private int goalTasksCompleted;

    public StudyProfile() {

        this.totalXP = 0;
        this.level = 1;

        this.currentStreak = 0;
        this.longestStreak = 0;

        this.monthlyTasksCompleted = 0;
        this.monthlyXP = 0;
        this.monthlyGoal = 20;

        this.monthlyPeriod =
                java.time.YearMonth.now().toString();

        this.studyGoal = "Set your study goal";
        this.goalTarget = 50;
        this.goalTasksCompleted = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public int getMonthlyTasksCompleted() {
        return monthlyTasksCompleted;
    }

    public void setMonthlyTasksCompleted(int monthlyTasksCompleted) {
        this.monthlyTasksCompleted = monthlyTasksCompleted;
    }

    public int getMonthlyXP() {
        return monthlyXP;
    }

    public void setMonthlyXP(int monthlyXP) {
        this.monthlyXP = monthlyXP;
    }

    public int getMonthlyGoal() {
        return monthlyGoal;
    }

    public void setMonthlyGoal(int monthlyGoal) {
        this.monthlyGoal = monthlyGoal;
    }

    public String getMonthlyPeriod() {
        return monthlyPeriod;
    }

    public void setMonthlyPeriod(String monthlyPeriod) {
        this.monthlyPeriod = monthlyPeriod;
    }

    // =========================
    // STUDY GOAL
    // =========================

    public String getStudyGoal() {
        return studyGoal;
    }

    public void setStudyGoal(String studyGoal) {
        this.studyGoal = studyGoal;
    }

    public int getGoalTarget() {
        return goalTarget;
    }

    public void setGoalTarget(int goalTarget) {
        this.goalTarget = goalTarget;
    }

    public int getGoalTasksCompleted() {
        return goalTasksCompleted;
    }

    public void setGoalTasksCompleted(int goalTasksCompleted) {
        this.goalTasksCompleted = goalTasksCompleted;
    }
}