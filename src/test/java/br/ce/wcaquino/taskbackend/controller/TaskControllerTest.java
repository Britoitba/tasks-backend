package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveTaskWithoutDescription() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try{
            taskController.save(todo);
            Assert.fail("should fall into the Exception");
        }catch(Exception e){
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithoutDate(){
        Task todo = new Task();
        todo.setTask("Testando sem Data");
        try{
            taskController.save(todo);
            Assert.fail("should fall into the Exception");
        }catch (Exception e){
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithPastDate(){
        Task todo = new Task();
        LocalDate date = LocalDate.of(2010, 01, 01);
        todo.setTask("Testando com Data Antiga");
        todo.setDueDate(date);
        try{
            taskController.save(todo);
            Assert.fail("should fall into the Exception");
        }catch (Exception e){
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void shouldSaveTaskWithSuccess() throws ValidationException {
        Task todo = new Task();
        todo.setTask("Testando save com sucesso");
        todo.setDueDate(LocalDate.now());
        taskController.save(todo);
        Mockito.verify(taskRepo).save(todo);
    }
}