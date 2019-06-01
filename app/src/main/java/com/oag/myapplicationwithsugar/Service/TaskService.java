package com.oag.myapplicationwithsugar.Service;

import com.oag.myapplicationwithsugar.Model.Task;
import com.orm.SugarRecord;

import java.util.List;

public class TaskService {

    private Task _task;

    public boolean saveTask(String title, String description){

        try{
            Task model = new Task(title,description);
            model.save();
            return true;
        }catch (Exception ex){
         return  false;
        }
    }


    public List<Task> GetAll(){
        List<Task> tasks = Task.listAll(Task.class);
        return tasks;
    }


    public Task GetById(long id){
         _task = Task.findById(Task.class , id);
        return _task;
    }

    public boolean Update(Task model , long id){
        try{
            Task task = Task.findById(Task.class, id);
            task.setTitle(model.getTitle());
            task.setDescription(model.getDescription());
            task.save();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean Delete(long id){
        try{
            Task task = Task.findById(Task.class, id);
            task.delete();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
