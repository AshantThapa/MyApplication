package com.m.myapplication.ui.home;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m.myapplication.R;
import com.m.myapplication.adapter.StudentAdapter;
import com.m.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    // Create a list of students to display in RecyclerView
    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recycler_view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recycler_view = root.findViewById(R.id.recycler_view);


        // Adding all the contacts object in list
        Student student = new Student("Ashant Thapa", "Thimi", "Male", 21);
        studentList = student.getStudentList();
        if(studentList.isEmpty()) {
            studentList.add(new Student("Ashant Thapa", "Thimi", "Male", 21));
            studentList.add(new Student("Goma Thapa", "Kathmandu", "Female", 20));
            student.setStudentList(studentList);
        }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(), studentList);
        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }
}
