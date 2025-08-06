package ra.com.dao;

import ra.com.entity.Project;

import java.util.List;

public interface ProjectDAO {
    List<Project> findAll();
    boolean addProject(Project project);
    Project findProjectById(int projectId);
    boolean updateProject(Project project);
    boolean deleteProject(int project);
}
