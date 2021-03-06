package com.rygelouv.androidaudiosensei;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rygelouv.audiosensei.player.AudioSenseiListObserver;
import com.rygelouv.audiosensei.player.AudioSenseiPlayerView;

import java.util.ArrayList;

/**
 Copyright 2017 Rygelouv.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 **/
public class ListAudioActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    AudioListAdapter adapter;
    private ArrayList<MyAudio> audioArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio);
        setTitle("Audio List in RecyclerView");
        AudioSenseiListObserver.getInstance().registerLifecycle(getLifecycle());
        loadAudio();
        recyclerView = findViewById(R.id.audio_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AudioListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void loadAudio()
    {
        //audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "https://firebasestorage.googleapis.com/v0/b/makeba-money.appspot.com/o/francisco-tarrega-lagrima.mp3?alt=media&token=0044d0b7-af7c-4919-b126-30032319fa23"));
        //audioArrayList.add(new MyAudio("Big Applause", "https://firebasestorage.googleapis.com/v0/b/makeba-money.appspot.com/o/SampleAudio_0.4mb.mp3?alt=media&token=bdc529df-a407-4353-bf63-9089d5224d16"));
        audioArrayList.add(new MyAudio("Big Applause", "/storage/emulated/0/Download/SampleAudio_0.4mb.mp3"));
        audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "storage/emulated/0/Download/francisco-tarrega-lagrima.mp3"));
        audioArrayList.add(new MyAudio("Big Applause", "/storage/emulated/0/Download/SampleAudio_0.4mb.mp3"));
        audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "storage/emulated/0/Download/francisco-tarrega-lagrima.mp3"));
        audioArrayList.add(new MyAudio("Big Applause", "/storage/emulated/0/Download/SampleAudio_0.4mb.mp3"));
        audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "storage/emulated/0/Download/francisco-tarrega-lagrima.mp3"));
        audioArrayList.add(new MyAudio("Big Applause", "/storage/emulated/0/Download/SampleAudio_0.4mb.mp3"));
        audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "storage/emulated/0/Download/francisco-tarrega-lagrima.mp3"));
        audioArrayList.add(new MyAudio("Big Applause", "/storage/emulated/0/Download/SampleAudio_0.4mb.mp3"));
        audioArrayList.add(new MyAudio("Francisco Tarrega Lagrima", "storage/emulated/0/Download/francisco-tarrega-lagrima.mp3"));
    }

    private class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.ViewHolder>
    {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(ListAudioActivity.this).inflate(R.layout.item_audio, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {
            MyAudio myAudio = audioArrayList.get(position);
            holder.audioSenseiPlayerView.setAudioTarget(Uri.parse(myAudio.url));
            holder.audioTitle.setText(myAudio.name);
        }

        @Override
        public int getItemCount()
        {
            return audioArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            AudioSenseiPlayerView audioSenseiPlayerView;
            TextView audioTitle;

            public ViewHolder(View itemView)
            {
                super(itemView);
                audioSenseiPlayerView = itemView.findViewById(R.id.audio_player);
                audioTitle = itemView.findViewById(R.id.audio_name);
            }
        }
    }


}
