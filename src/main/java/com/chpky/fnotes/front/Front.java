package com.chpky.fnotes.front;

import com.chpky.fnotes.front.session.UserSession;

public class Front implements FtBase{

    private final FtBase[] frontParts;

    public Front(FtBase... frontParts) {
        this.frontParts = frontParts;
    }

    @Override
    public void start(UserSession session) throws Exception {
        for (FtBase frontPart : frontParts) {
            frontPart.start(session);
        }
    }
}
