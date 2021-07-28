package com.tencent.qcloud.tim.demo.contact;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.text.TextUtils;

import com.tencent.qcloud.tim.demo.utils.TencentApp;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.qcloud.tim.demo.BaseActivity;

import com.tencent.qcloud.tim.demo.R;
import com.tencent.qcloud.tim.demo.chat.ChatActivity;
import com.tencent.qcloud.tim.demo.main.IMMainActivity;
import com.tencent.qcloud.tim.demo.utils.Constants;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.tencent.qcloud.tim.uikit.modules.contact.FriendProfileLayout;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;

public class FriendProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_friend_profile_activity);
        FriendProfileLayout layout = findViewById(R.id.friend_profile);

        layout.initData(getIntent().getSerializableExtra(TUIKitConstants.ProfileType.CONTENT));
        layout.setOnButtonClickListener(new FriendProfileLayout.OnButtonClickListener() {
            @Override
            public void onStartConversationClick(ContactItemBean info) {
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setType(V2TIMConversation.V2TIM_C2C);
                chatInfo.setId(info.getId());
                String chatName = info.getId();
                if (!TextUtils.isEmpty(info.getRemark())) {
                    chatName = info.getRemark();
                } else if (!TextUtils.isEmpty(info.getNickname())) {
                    chatName = info.getNickname();
                }
                chatInfo.setChatName(chatName);
                Intent intent = new Intent(TencentApp.get(), ChatActivity.class);
                intent.putExtra(Constants.CHAT_INFO, chatInfo);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                TencentApp.get().startActivity(intent);
            }

            @Override
            public void onDeleteFriendClick(String id) {
                Intent intent = new Intent(TencentApp.get(), IMMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
