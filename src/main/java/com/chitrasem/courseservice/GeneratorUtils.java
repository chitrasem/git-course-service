package com.chitrasem.courseservice;

import java.util.Random;

public class GeneratorUtils {
    private static final String[] ADJECTIVES = {
      "Comprehensive",
      "Interactive",
      "Engaging",
      "Practical",
      "In-depth",
      "Advanced",
      "Fundamental",
      "Specialized",
      "Hands-on",
      "Cutting-edge"
    };
    private static final String[] SUBJECTS = {
        "Web Development",
        "Data Science",
        "Machine Learning",
        "Mobile App Development",
        "Cybersecurity",
        "Blockchain",
        "Artificial Intelligence",
        "Cloud Computing",
        "Internet of Things"
    };
    private static final String[] ACTIONS = {
        "explore",
        "master",
        "learn",
        "understand",
        "build",
        "apply",
        "utilize",
        "implement",
        "create",
        "enhance"
    };
    public static String generateTopic(){
        Random random = new Random();
        int adj_index = random.nextInt(ADJECTIVES.length);
        int sub_index = random.nextInt(SUBJECTS.length);
        int act_ineex = random.nextInt(ACTIONS.length);

        String description = ADJECTIVES[adj_index] + " course on " + SUBJECTS[sub_index] + " where you'll " + ACTIONS[act_ineex] + " the concenpt";

        return description;

    }
    public static void main(String[] args) {
        System.out.println(generateTopic());
    }
}
