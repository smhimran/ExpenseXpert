package com.expensexpert.expensexpert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MemberFragment extends Fragment {

    private ArrayList<Member> memberlist;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_members, container, false);


        recyclerView = root.findViewById(R.id.member_list);
        memberlist = new ArrayList<>();
        fab = root.findViewById(R.id.add_member);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddMember.class);
                startActivity(intent);
            }
        });

        setMemberInfo();
        setAdapter();
        return root;
    }

    private void setAdapter() {
        MemberAdapter adapter = new MemberAdapter(memberlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMemberInfo() {
        memberlist.add(new Member("Member 1", 400, 100));
        memberlist.add(new Member("Member 2", 100, 200));
    }
}
