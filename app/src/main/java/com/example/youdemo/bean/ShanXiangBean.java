package com.example.youdemo.bean;

import java.util.List;

/**
 * author：  jcy
 * data：2020/5/27
 * time：16:18
 * description：
 */
public class ShanXiangBean {

    /**
     * code : 0
     * success : 1
     * message : success
     * data : {"mold":{"all_sum":"已有252人报名参加模考"},"recom":[{"id":"2","third_paper_id":"1002","title":"2020年教师招聘【学科】笔试系统班模考2","type":"0","grade":"0","discipline_id":"0","start_time":"1590480081","show_time":"1590220881","hidden_time":"1590652881","paper_info":{"id":"4","paper_id":"2","enroll_num":"52","exam_num":"12"},"avg_score":"0.00","status":"0"},{"id":"1","third_paper_id":"1001","title":"2020年教师招聘【学科】笔试系统班模考1","type":"0","grade":"1","discipline_id":"1","start_time":"1590649281","show_time":"1590390081","hidden_time":"1590822081","paper_info":{"id":"2","paper_id":"1","enroll_num":"200","exam_num":"50"},"avg_score":"0.00","status":"0"}]}
     */

    private int code;
    private int success;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShanXiangBean{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * mold : {"all_sum":"已有252人报名参加模考"}
         * recom : [{"id":"2","third_paper_id":"1002","title":"2020年教师招聘【学科】笔试系统班模考2","type":"0","grade":"0","discipline_id":"0","start_time":"1590480081","show_time":"1590220881","hidden_time":"1590652881","paper_info":{"id":"4","paper_id":"2","enroll_num":"52","exam_num":"12"},"avg_score":"0.00","status":"0"},{"id":"1","third_paper_id":"1001","title":"2020年教师招聘【学科】笔试系统班模考1","type":"0","grade":"1","discipline_id":"1","start_time":"1590649281","show_time":"1590390081","hidden_time":"1590822081","paper_info":{"id":"2","paper_id":"1","enroll_num":"200","exam_num":"50"},"avg_score":"0.00","status":"0"}]
         */

        private MoldBean mold;
        private List<RecomBean> recom;

        public MoldBean getMold() {
            return mold;
        }

        public void setMold(MoldBean mold) {
            this.mold = mold;
        }

        public List<RecomBean> getRecom() {
            return recom;
        }

        public void setRecom(List<RecomBean> recom) {
            this.recom = recom;
        }

        public static class MoldBean {
            /**
             * all_sum : 已有252人报名参加模考
             */

            private String all_sum;

            public String getAll_sum() {
                return all_sum;
            }

            public void setAll_sum(String all_sum) {
                this.all_sum = all_sum;
            }
        }

        public static class RecomBean {
            /**
             * id : 2
             * third_paper_id : 1002
             * title : 2020年教师招聘【学科】笔试系统班模考2
             * type : 0
             * grade : 0
             * discipline_id : 0
             * start_time : 1590480081
             * show_time : 1590220881
             * hidden_time : 1590652881
             * paper_info : {"id":"4","paper_id":"2","enroll_num":"52","exam_num":"12"}
             * avg_score : 0.00
             * status : 0
             */

            private String id;
            private String third_paper_id;
            private String title;
            private String type;
            private String grade;
            private String discipline_id;
            private String start_time;
            private String show_time;
            private String hidden_time;
            private PaperInfoBean paper_info;
            private String avg_score;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getThird_paper_id() {
                return third_paper_id;
            }

            public void setThird_paper_id(String third_paper_id) {
                this.third_paper_id = third_paper_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getDiscipline_id() {
                return discipline_id;
            }

            public void setDiscipline_id(String discipline_id) {
                this.discipline_id = discipline_id;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getShow_time() {
                return show_time;
            }

            public void setShow_time(String show_time) {
                this.show_time = show_time;
            }

            public String getHidden_time() {
                return hidden_time;
            }

            public void setHidden_time(String hidden_time) {
                this.hidden_time = hidden_time;
            }

            public PaperInfoBean getPaper_info() {
                return paper_info;
            }

            public void setPaper_info(PaperInfoBean paper_info) {
                this.paper_info = paper_info;
            }

            public String getAvg_score() {
                return avg_score;
            }

            public void setAvg_score(String avg_score) {
                this.avg_score = avg_score;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public static class PaperInfoBean {
                /**
                 * id : 4
                 * paper_id : 2
                 * enroll_num : 52
                 * exam_num : 12
                 */

                private String id;
                private String paper_id;
                private String enroll_num;
                private String exam_num;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPaper_id() {
                    return paper_id;
                }

                public void setPaper_id(String paper_id) {
                    this.paper_id = paper_id;
                }

                public String getEnroll_num() {
                    return enroll_num;
                }

                public void setEnroll_num(String enroll_num) {
                    this.enroll_num = enroll_num;
                }

                public String getExam_num() {
                    return exam_num;
                }

                public void setExam_num(String exam_num) {
                    this.exam_num = exam_num;
                }
            }
        }
    }
}
