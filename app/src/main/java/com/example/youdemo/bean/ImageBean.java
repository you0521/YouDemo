package com.example.youdemo.bean;

import java.util.List;

public class ImageBean {

    /**
     * code : 200
     * ret : success
     * images : [{"id":1,"uid":"1","imageid":1,"url":"http://yun918.cn/study/public/res/imgs/270-140.png"},{"id":2,"uid":"1","imageid":2,"url":"http://yun918.cn/study/public/res/imgs/728827134.jpg"},{"id":3,"uid":"1","imageid":3,"url":"http://yun918.cn/study/public/res/imgs/645088894.jpg"},{"id":4,"uid":"1","imageid":4,"url":"http://yun918.cn/study/public/res/imgs/3581792254.jpg"}]
     */

    private int code;
    private String ret;
    private List<ImagesBean> images;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * id : 1
         * uid : 1
         * imageid : 1
         * url : http://yun918.cn/study/public/res/imgs/270-140.png
         */

        private int id;
        private String uid;
        private int imageid;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getImageid() {
            return imageid;
        }

        public void setImageid(int imageid) {
            this.imageid = imageid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
