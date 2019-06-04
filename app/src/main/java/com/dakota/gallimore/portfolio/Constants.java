package com.dakota.gallimore.portfolio;

/**
 * Created by Dakota on 10/26/2017.
 */

public class Constants {

    public static String[] parentEducationTitles = {"What I bring", "Education", "Experience", "Skills"};

    public static String[] childEducationWIBHeaders = {"Microservice/Container Knowledgable",
            "Mobile Focused",
            "Full-stack expertise",
            "Quality programming and design skills",
            "Quick Learner"
    };
    public static String[] childEducationEDUHeaders = {"B.S. in Software Engineering",
            "B.S. in Computer Science",
            "Udacity"};
    public static String[] childEducationEXPHeaders = {
            "Application Developer II",
            "CEO / Founder",
            "Android Developer",
            "Systems Admin"};
    public static String[] childEducationSkillsHeaders = {"Kubernetes Expertise",
            "Amazon Web Service Knowledgable",
            "NodeJs + Typescript",
            "Angular 2+",
            "Client Relations",
            "Android"
    };

    public static String[] childEducationBlankDates = {"", "", "", "", "", ""};
    public static String[] childEducationEDUDate = {"2009 - 2015", "2009 - 2015", "2016 - Ongoing"};
    public static String[] childEducationEXPDate = {"2017 - 2019", "2012 - 2017", "2011 - 2016", "2013 - 2015"};

    public static String[] childEducationWIBDetails = {
            "Having developed within a microservice system for two years, I'm familiar with common design patterns like Sidecar or Adapter.",
            "My roots are in Android programming. I always think mobile first even when designing the backend.",
            "Having started with client facing applications on Android to now designing complete Openshift/K8s architectures, I'm comfortable at any level of a software stack.",
            "Clean code is maintainable code, you should always leave the code better than you found it as such, I'm a programmer with the ability to create high quality and maintainable code.",
            "With a desire to constantly be learning I'm able to adapt to changing scenarios and pick up new skillsets within short timeframes."
    };
    public static String[] childEducationEDUDetails = {
            "The University of Virginia's College at Wise.",
            "The University of Virginia's College at Wise.",
            "Classes taught by Google and other industry leaders. Completed classes range from Android development to Machine Learning and Self-Driving Cars."
    };
    public static String[] childEducationEXPDetails = {
            "1901Group",
            "Dreams.Build",
            "Self and minor freelancing",
            "Highland Cavalier Newspaper"
    };
    public static String[] childEducationSkillsDetails = {
            "I'm proficient in the Kubernetes ecosystem, making me capable of quickly debugging and building applications at scale.",
            "I'm familiar with numerous AWS product offerings and how best to apply and scale those features to meet client demands in commercial as well as GovCloud.",
            "I've worked extensively in Typescript that heavily leverages RxJs observable across the full-stack.",
            "Along with working with an Express backend, I'm fluent in using Angular 2+ as a client facing frontend that leverage an Akita (Redux) datastore.",
            "I've helped numerous startups define their technology offerings and mobile experiences on a global scale.",
            "I leveraged Android while learning the Java programming language, in a way, Android is the first 'language' I learned."
    };

    public static String[][] childAllHeaders = {
            childEducationWIBHeaders,
            childEducationEDUHeaders,
            childEducationEXPHeaders,
            childEducationSkillsHeaders
    };
}
