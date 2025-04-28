package Problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void test_add_problem(){
        Person person = new Person();

        person.add("hsgc",TypesOfProblem.BUSINESS,"jdviwy");
        person.add("hidgho",TypesOfProblem.EDUCATION,"jduizfg");
        person.add("hsgc",TypesOfProblem.FINANCIAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.SPIRITUAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.TECHNICAL,"jdviwy");

        assertEquals(5,person.getProblems().size());

    }

    @Test
    public void test_find_problem(){
        Person person = new Person();

        person.add("hsgc",TypesOfProblem.BUSINESS,"jdviwy");
        person.add("hidgho",TypesOfProblem.EDUCATION,"jduizfg");
        person.add("hsgc",TypesOfProblem.FINANCIAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.SPIRITUAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.TECHNICAL,"jdviwy");


        assertEquals(person.findProblem("hidgho",TypesOfProblem.EDUCATION).toString(),
                "problem name: hidgho, problem type: EDUCATION, problem body: jduizfg problem solved: false");
        assertNull(person.findProblem("hidgho",TypesOfProblem.FINANCIAL));
    }

    @Test
    public void test_solve_problem(){
        Person person = new Person();
        person.add("hsgc",TypesOfProblem.BUSINESS,"jdviwy");
        person.add("hidgho",TypesOfProblem.EDUCATION,"jduizfg");
        person.add("hsgc",TypesOfProblem.FINANCIAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.SPIRITUAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.TECHNICAL,"jdviwy");

        person.solve("hidgho",TypesOfProblem.EDUCATION);
        assertEquals(person.findProblem("hidgho",TypesOfProblem.EDUCATION).toString(),
                "problem name: hidgho, problem type: EDUCATION, problem body: jduizfg problem solved: true");

    }

    @Test
    public void test_count_problem(){
        Person person = new Person();
        person.add("hsgc",TypesOfProblem.BUSINESS,"jdviwy");
        person.add("hidgho",TypesOfProblem.EDUCATION,"jduizfg");
        person.add("hsgc",TypesOfProblem.FINANCIAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.SPIRITUAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.TECHNICAL,"jdviwy");

        person.solve("hidgho",TypesOfProblem.EDUCATION);
        person.solve("hsgc",TypesOfProblem.FINANCIAL);
        assertEquals(3,person.countProblem());
    }

    @Test
    public void test_get_all_unsolved_problem(){
        Person person = new Person();
        person.add("hsgc",TypesOfProblem.BUSINESS,"jdviwy");
        person.add("hidgho",TypesOfProblem.EDUCATION,"jduizfg");
        person.add("hsgc",TypesOfProblem.FINANCIAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.SPIRITUAL,"jdviwy");
        person.add("hsgc",TypesOfProblem.TECHNICAL,"jdviwy");

        person.solve("hidgho",TypesOfProblem.EDUCATION);
        person.solve("hsgc",TypesOfProblem.FINANCIAL);


        assertEquals(3, person.getAllUnsolvedProblem().size());
    }
}