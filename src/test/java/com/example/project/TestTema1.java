package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestTema1
{

    @Test
    public void testDummy()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(null);


        //System.out.println(bos.toString().trim());
        // assertion
        assertEquals("Hello world!", bos.toString().trim());
        //assertEquals(true, true);

        // undo the binding in System
        System.setOut(originalOut);
    }

    //region 1 Creare utilizator
    @Test
    public void testCreateUserUserAlreadyExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'uchii_cu_cel'", "-p 'unghii2022'"});

        // assertion
//       assertEquals("{ 'status' : 'ok', 'message' : 'User created successfully'}".replace("' ", "'").replace(" '","'"),
//               bos.toString().trim().replace("' ", "'").replace(" '","'"));

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action

        Tema1.main(new String[]{"-create-user", "-u 'uchii_cu_cel'", "-p 'unghii2022'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'User already exists'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateUserNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Please provide username'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateUserNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'uchii_cu_cel'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Please provide password'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateUserUserCreatedSuccesfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'uchii_cu_cel'", "-p 'unghii2022'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : 'User created successfully'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    //endregion

    //region 2 Creare întrebare
    @Test
    public void testCreateQuestionNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuestionNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuestionUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuestionLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuestionWithExistingName()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));


        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Question already exists'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testQuestionHasNoAnswers()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No answer provided'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testQuestionHasOnlyOneAnswer()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Only one answer provided'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testQuestionHasNoText()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No question text provided'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSingleAnswerQuestionHasMultipleCorrectAnswers()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'","-answer-2 'No'", "-answer-2-is-correct '1'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Single correct answer question has more than one correct answer'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});

    }

    @Test
    public void testQuestionDuplicateAnswers()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1 'Yes'", "-answer-1-is-correct '1'","-answer-2 'Yes'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Same answer provided more than once'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testQuestionAnswerHasNoDescription()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'", "-answer-1-is-correct '1'","-answer-2 'Yes'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Answer 1 has no answer description'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testQuestionAnswerHasNoAnswerFlag()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'","-answer-2 'No'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Answer 1 has no answer correct flag'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuestionSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : 'Question added successfully'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    //endregion

    //region 3 Întoarce identificator întrebare după nume
    @Test
    public void testGetQuestionNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-question-id-by-text"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuestionNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-question-id-by-text", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuestionUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-question-id-by-text", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuestionLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-question-id-by-text", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuestionNotFound()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        //action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-question-id-by-text", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Question does not exist'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuestionSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-get-question-id-by-text", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'"});


        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '1'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }
    //endregion

    //region 4 Întoarce toate întrebările din system
    @Test
    public void testGetAllQuestionsNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-questions"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuestionsNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-questions", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuestionsUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-questions", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuestionsLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-questions", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuestionsSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate masura in'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-questions", "-u 'test'", "-p 'test'"});
        //assertion
        assertEquals("{ 'status' : 'ok', 'message' : '[{\"question_id\" : \"1\", \"question_name\" : \"Cerul este albastru\"}, {\"question_id\" : \"2\", \"question_name\" : \"Temperatura se poate masura in\"}]'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '", "'"));


        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    //endregion

    //region 5 Creare chestionar

    @Test
    public void testCreateQuizNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizNameAlreadyExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        //action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Quizz name already exists'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizQuestionIdDoesNotExist()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Question ID for question 2 does not exist'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testCreateQuizSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : 'Quizz added succesfully'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});

    }
    //endregion

    //region 6 Întoarce identificator chestionar după nume

    @Test
    public void testGetQuizNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-by-name"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-by-name", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-by-name", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-by-name", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizNotFound()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        //action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-by-name", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Quizz does not exist'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-get-quizz-by-name", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '1'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    //endregion

    //region 7 Întoarce toate chestionarele din system
    @Test
    public void testGetAllQuizezNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-quizzes"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuizezNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-quizzes", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuizezUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-quizzes", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuizezLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-all-quizzes", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetAllQuizezSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Intrebarea 3'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Intrebarea 4'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 2'", "-question-1 '3'", "-question-2 '4'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-get-all-quizzes", "-u 'test'", "-p 'test'"});



        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '[{\"quizz_id\" : \"1\", \"quizz_name\" : \"Chestionarul 1\", \"is_completed\" : \"False\"}, {\"quizz_id\" : \"2\", \"quizz_name\" : \"Chestionarul 2\", \"is_completed\" : \"False\"}]'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }
    //endregion

    //region 8 Întoarce detaliile unui chestionar în funcție de identificatory java

    @Test
    public void testGetQuizDetailsNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-details-by-id"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizDetailsNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-details-by-id", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizDetailsUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-details-by-id", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetQuizDetailsLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-quizz-details-by-id", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    @Test
    public void testGetQuizDetailsSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate masura in'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-get-quizz-details-by-id", "-u 'test'", "-p 'test'", "-id '1'"});

        // assertion
        assertEquals("{'status':'ok','message':'[{\"question-name\":\"Cerul este albastru\", \"question_index\":\"1\", \"question_type\":\"single\", \"answers\":\"[{\"answer_name\":\"Yes\", \"answer_id\":\"1\"}, {\"answer_name\":\"No\", \"answer_id\":\"2\"}]\"}, {\"question-name\":\"Temperatura se poate masura in\", \"question_index\":\"2\", \"question_type\":\"single\", \"answers\":\"[{\"answer_name\":\"C\", \"answer_id\":\"3\"}, {\"answer_name\":\"L\", \"answer_id\":\"4\"}]\"}]'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    //endregion

    //region 9 Încarcă răspunsuri chestionar
    @Test
    public void testSubmitQuizNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-submit-quizz"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuizNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-submit-quizz", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuizUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-submit-quizz", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuizLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-submit-quizz", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuizNoId()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-submit-quizz", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No quizz identifier was provided'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    @Test
    public void testSubmitQuizNotFound()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test'", "-p 'test'", "-quiz-id '2'", "-answer-id-1 '1'", "-answer-id-2 '3'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No quiz was found'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    @Test
    public void testSubmitQuizSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-user", "-u 'test2'", "-p 'test2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test2'", "-p 'test2'", "-quiz-id '1'", "-answer-id-1 '1'", "-answer-id-2 '3'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '100 points'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuizAnsweredWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-user", "-u 'test2'", "-p 'test2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test2'", "-p 'test2'", "-quiz-id '1'", "-answer-id-1 '2'", "-answer-id-2 '4'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '0 points'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuiz2Of3QuestionsAnswered()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-user", "-u 'test2'", "-p 'test2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'multiple'","-answer-1 'Celsius'", "-answer-1-is-correct '1'", "-answer-2 'Litri'", "-answer-2-is-correct '0'", "-answer-3 'Fahrenheit'", "-answer-3-is-correct '1'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Urmatoarele sunt animale de companie'", "-type 'multiple'","-answer-1 'Caine'", "-answer-1-is-correct '1'", "-answer-2 'Grifon'", "-answer-2-is-correct '0'", "-answer-3 'Pisica'", "-answer-3-is-correct '1'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'", "-question-3 '3'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test2'", "-p 'test2'", "-quiz-id '1'", "-answer-id-1 '3'", "-answer-id-2 '5'", "-answer-id-3 '6'", "-answer-id-4 '8'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '67 points'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testSubmitQuiz1QuestionAnsweredWrong2QuestionsAnsweredCorectly()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-user", "-u 'test2'", "-p 'test2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'multiple'","-answer-1 'Celsius'", "-answer-1-is-correct '1'", "-answer-2 'Litri'", "-answer-2-is-correct '0'", "-answer-3 'Fahrenheit'", "-answer-3-is-correct '1'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Urmatoarele sunt animale de companie'", "-type 'multiple'","-answer-1 'Caine'", "-answer-1-is-correct '1'", "-answer-2 'Grifon'", "-answer-2-is-correct '0'", "-answer-3 'Pisica'", "-answer-3-is-correct '1'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'", "-question-3 '3'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test2'", "-p 'test2'", "-quiz-id '1'", "-answer-id-1 '2'", "-answer-id-2 '3'", "-answer-id-3 '5'", "-answer-id-4 '6'", "-answer-id-5 '8'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '33 points'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }
    //endregion

    //region 10 Ștergere chestionar
    @Test
    public void testDeleteQuizNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-delete-quizz-by-id"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testDeleteQuizNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testDeleteQuizUsernameDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testDeleteQuizLoginCredentialsAreWrong()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testDeleteQuizNoId()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No quizz identifier was provided'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    @Test
    public void testDeleteQuizNotFound()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'", "-p 'test'", "-id '2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'No quiz was found'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }


    @Test
    public void testDeleteQuizSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-delete-quizz-by-id", "-u 'test'", "-p 'test'", "-id '1'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : 'Quizz deleted successfully'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    //endregion


    //region 11 Întoarce soluțiile mele
    @Test
    public void testGetSolutionsNoUsername()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-my-solutions"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetSolutionsNoPassword()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-my-solutions", "-u 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'You need to be authenticated'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetSolutionsUserDoesNotExists()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-my-solutions", "-u 'test'", "-p 'test'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetSolutionsWrongCredentials()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-get-my-solutions", "-u 'test'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'error', 'message' : 'Login failed'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    @Test
    public void testGetSolutionsSuccessfully()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-cleanup-all"});
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-user", "-u 'test'", "-p 'test'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-user", "-u 'test2'", "-p 'test2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Cerul este albastru'", "-type 'single'","-answer-1 'Yes'", "-answer-1-is-correct '1'", "-answer-2 'No'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-question", "-u 'test'", "-p 'test'", "-text 'Temperatura se poate măsura în'", "-type 'single'","-answer-1 'C'", "-answer-1-is-correct '1'", "-answer-2 'L'", "-answer-2-is-correct '0'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Tema1.main(new String[]{"-create-quizz", "-u 'test'", "-p 'test'", "-name 'Chestionarul 1'", "-question-1 '1'", "-question-2 '2'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-submit-quizz", "-u 'test2'", "-p 'test2'", "-quiz-id '1'", "-answer-id-1 '1'", "-answer-id-2 '3'"});

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Tema1.main(new String[]{"-get-my-solutions", "-u 'test2'", "-p 'test2'"});

        // assertion
        assertEquals("{ 'status' : 'ok', 'message' : '[{\"quiz-id\" : \"1\", \"quiz-name\" : \"Chestionarul 1\", \"score\" : \"100\", \"index_in_list\" : \"1\"}]'}".replace("' ", "'").replace(" '","'"),
                bos.toString().trim().replace("' ", "'").replace(" '","'"));

        // undo the binding in System
        System.setOut(originalOut);

        // action
        Tema1.main(new String[]{"-cleanup-all"});
    }

    //endregion
}