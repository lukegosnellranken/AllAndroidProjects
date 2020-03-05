package com.gmail.gosnellwebdesign.recyclerviewblues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewBluesTeamInfo;
    List<HockeyTeam> teamList = new ArrayList<>();
    HockeyTeamAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewBluesTeamInfo = findViewById(R.id.recyclerViewBluesTeamInfo);
        setTeamData();
        adapter = new HockeyTeamAdapter(teamList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerViewBluesTeamInfo.setLayoutManager(manager);
        recyclerViewBluesTeamInfo.setAdapter(adapter);
    }

    private void setTeamData()
    {
        HockeyTeam team = new HockeyTeam("Jake Allen", "Goalie", "34");
        teamList.add(team);

        team = new HockeyTeam("Ivan Barbashev", "Right Winger", "49");
        teamList.add(team);

        team = new HockeyTeam("Jordan Binnington", "Goalie", "50");
        teamList.add(team);

        team = new HockeyTeam("Sammy Blais", "Right Winger", "9");
        teamList.add(team);

        team = new HockeyTeam("Robert Bortuzzo", "Defender", "41");
        teamList.add(team);

        team = new HockeyTeam("Tyler Bozak", "Right Winger", "21");
        teamList.add(team);

        team = new HockeyTeam("Troy Brouwer", "Right Winger", "36");
        teamList.add(team);

        team = new HockeyTeam("Jacob de la Rose", "Center", "61");
        teamList.add(team);

        team = new HockeyTeam("Vince Dunn", "Defender", "29");
        teamList.add(team);

        team = new HockeyTeam("Justin Faulk", "Defender", "72");
        teamList.add(team);

        team = new HockeyTeam("Carl Gunnarsson", "Defender", "4");
        teamList.add(team);

        team = new HockeyTeam("Jordan Kyrou", "Right Winger", "33");
        teamList.add(team);

        team = new HockeyTeam("MacKenzie MacEachern", "Left Winger", "28");
        teamList.add(team);

        team = new HockeyTeam("Ryan O'Reilly", "Center", "90");
        teamList.add(team);

        team = new HockeyTeam("Colton Parayko", "Defender", "55");
        teamList.add(team);

        team = new HockeyTeam("David Perron", "Right Winger", "57");
        teamList.add(team);

        team = new HockeyTeam("Alex Pietrangelo", "Defender", "27");
        teamList.add(team);

        team = new HockeyTeam("Zach Sanford", "Left Winger", "12");
        teamList.add(team);

        team = new HockeyTeam("Marco Scandella", "Defender", "6");
        teamList.add(team);

        team = new HockeyTeam("Brayden Schenn", "Center", "10");
        teamList.add(team);

        team = new HockeyTeam("Jaden Schwartz", "Left Winger", "17");
        teamList.add(team);

        team = new HockeyTeam("Alexander Steen", "Left Winger", "20");
        teamList.add(team);

        team = new HockeyTeam("Oskar Sundqvist", "Right Winger", "70");
        teamList.add(team);

        team = new HockeyTeam("Robert Thomas", "Center", "18");
        teamList.add(team);
    }
}
