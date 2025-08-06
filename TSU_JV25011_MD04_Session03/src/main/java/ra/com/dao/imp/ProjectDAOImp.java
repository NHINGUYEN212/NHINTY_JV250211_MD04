package ra.com.dao.imp;

import ra.com.dao.ProjectDAO;
import ra.com.entity.Project;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImp implements ProjectDAO {
    @Override
    public List<Project> findAll() {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Project> listProjects = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call find_all_projects()}");
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("project_id"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("project_description"));
                project.setImage(rs.getString("project_image"));
                listProjects.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return listProjects;
    }

    @Override
    public boolean addProject(Project project) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call create_project(?,?,?)}");
            callStmt.setString(1, project.getName());
            callStmt.setString(2, project.getDescription());
            callStmt.setString(3, project.getImage());
            callStmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    @Override
    public Project findProjectById(int id) {
        Connection conn = null;
        CallableStatement callStmt = null;
        Project project = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call find_project_by_id(?)}");
            callStmt.setInt(1, id);
            ResultSet rs = callStmt.executeQuery();
            if (rs.next()) {
                project = new Project();
                project.setId(rs.getInt("project_id"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("project_description"));
                project.setImage(rs.getString("project_image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return project;
    }

    @Override
    public boolean updateProject(Project project) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call update_project(?,?,?,?)}");
            callStmt.setInt(1, project.getId());
            callStmt.setString(2, project.getName());
            callStmt.setString(3, project.getDescription());
            callStmt.setString(4, project.getImage());
            callStmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    @Override
    public boolean deleteProject(int id) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call delete_project(?)}");
            callStmt.setInt(1, id);
            callStmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }
}
