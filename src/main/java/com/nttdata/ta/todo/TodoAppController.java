package com.nttdata.ta.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoAppController {

    @Autowired
    private TodoItemRepository repository;

    @Autowired
    private StudyProfileRepository profileRepository;

    @GetMapping("/")
    public String index(Model model) {

        Iterable<TodoItem> todoList =
                repository.findAll();

        StudyProfile profile =
                getProfile();

        model.addAttribute(
                "items",
                new TodoListViewModel(todoList)
        );

        model.addAttribute(
                "newitem",
                new TodoItem()
        );

        model.addAttribute(
                "profile",
                profile
        );

        return "index";
    }

    // =========================
    // ADD TASK
    // =========================

    @PostMapping("/add")
    public String add(
            @ModelAttribute TodoItem requestItem) {

        TodoItem item =
                new TodoItem(
                        requestItem.getCategory(),
                        requestItem.getName()
                );

        item.setPriority(
                requestItem.getPriority()
        );

        repository.save(item);

        return "redirect:/";
    }

    // =========================
    // UPDATE TASKS
    // =========================

    @PostMapping("/update")
    public String update(
            @ModelAttribute TodoListViewModel requestItems) {

        StudyProfile profile =
                getProfile();

        for (TodoItem requestItem :
                requestItems.getTodoList()) {

            TodoItem existingItem =
                    repository.findById(
                            requestItem.getId()
                    ).orElse(null);

            if (existingItem == null) {
                continue;
            }

            /*
             * Completing a task:
             *
             * 1. Award XP
             * 2. Increase monthly completed tasks
             * 3. Increase monthly XP
             * 4. Increase study goal progress
             * 5. Delete completed task
             */

            if (requestItem.isComplete()) {

                int xp =
                        calculateXP(
                                existingItem.getPriority()
                        );

                profile.setTotalXP(
                        profile.getTotalXP() + xp
                );

                profile.setMonthlyTasksCompleted(
                        profile.getMonthlyTasksCompleted() + 1
                );

                profile.setMonthlyXP(
                        profile.getMonthlyXP() + xp
                );

                // Increase Study Goal progress
                if (profile.getGoalTasksCompleted()
                        < profile.getGoalTarget()) {

                    profile.setGoalTasksCompleted(
                            profile.getGoalTasksCompleted() + 1
                    );
                }

                repository.delete(
                        existingItem
                );

                continue;
            }

            /*
             * Task is still incomplete.
             */

            existingItem.setName(
                    requestItem.getName()
            );

            existingItem.setCategory(
                    requestItem.getCategory()
            );

            existingItem.setPriority(
                    requestItem.getPriority()
            );

            existingItem.setComplete(false);

            repository.save(
                    existingItem
            );
        }

        updateLevel(profile);

        profileRepository.save(profile);

        return "redirect:/";
    }

    // =========================
    // SAVE STUDY GOAL
    // =========================

    @PostMapping("/goal")
    public String updateGoal(
            @RequestParam String studyGoal,
            @RequestParam int goalTarget) {

        StudyProfile profile =
                getProfile();

        profile.setStudyGoal(
                studyGoal.trim()
        );

        profile.setGoalTarget(
                goalTarget
        );

        profileRepository.save(
                profile
        );

        return "redirect:/";
    }

    // =========================
    // XP CALCULATION
    // =========================

    private int calculateXP(
            String priority) {

        if ("HIGH".equals(priority)) {
            return 30;
        }

        if ("LOW".equals(priority)) {
            return 10;
        }

        return 20;
    }

    // =========================
    // LEVEL
    // =========================

    private void updateLevel(
            StudyProfile profile) {

        int level =
                (profile.getTotalXP() / 100) + 1;

        profile.setLevel(level);
    }

    // =========================
    // GET PROFILE
    // =========================

    private StudyProfile getProfile() {

        java.util.Iterator<StudyProfile> iterator =
                profileRepository.findAll()
                        .iterator();

        if (iterator.hasNext()) {

            StudyProfile profile =
                    iterator.next();

            /*
             * Existing database records were created
             * before monthly progress existed.
             */

            if (profile.getMonthlyGoal() == 0) {

                profile.setMonthlyGoal(20);
            }

            /*
             * Existing database records were created
             * before Study Goal existed.
             */

            if (profile.getStudyGoal() == null ||
                    profile.getStudyGoal().isEmpty()) {

                profile.setStudyGoal(
                        "Set your study goal"
                );
            }

            if (profile.getGoalTarget() == 0) {

                profile.setGoalTarget(50);
            }

            /*
             * AUTOMATIC MONTHLY RESET
             *
             * totalXP and level are lifetime values.
             *
             * monthlyTasksCompleted and monthlyXP
             * reset automatically when a new month begins.
             */

            String currentMonth =
                    java.time.YearMonth.now().toString();

            if (profile.getMonthlyPeriod() == null ||
                    !profile.getMonthlyPeriod()
                            .equals(currentMonth)) {

                profile.setMonthlyTasksCompleted(0);

                profile.setMonthlyXP(0);

                profile.setMonthlyPeriod(
                        currentMonth
                );

                profileRepository.save(profile);
            }

            return profile;
        }

        return profileRepository.save(
                new StudyProfile()
        );
    }
}