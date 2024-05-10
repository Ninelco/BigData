// ORM class for table 'ctr'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri May 10 18:30:32 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ctr extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("session_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.session_id = (Integer)value;
      }
    });
    setters.put("datetime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.datetime = (java.sql.Timestamp)value;
      }
    });
    setters.put("user_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.user_id = (Integer)value;
      }
    });
    setters.put("product", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.product = (String)value;
      }
    });
    setters.put("campaign_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.campaign_id = (Integer)value;
      }
    });
    setters.put("webpage_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.webpage_id = (Integer)value;
      }
    });
    setters.put("product_category_1", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.product_category_1 = (Integer)value;
      }
    });
    setters.put("product_category_2", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.product_category_2 = (Double)value;
      }
    });
    setters.put("user_group_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.user_group_id = (Double)value;
      }
    });
    setters.put("gender", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.gender = (String)value;
      }
    });
    setters.put("age_level", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.age_level = (Double)value;
      }
    });
    setters.put("user_depth", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.user_depth = (Double)value;
      }
    });
    setters.put("city_development_index", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.city_development_index = (Double)value;
      }
    });
    setters.put("var_1", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.var_1 = (Integer)value;
      }
    });
    setters.put("is_click", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ctr.this.is_click = (Integer)value;
      }
    });
  }
  public ctr() {
    init0();
  }
  private Integer session_id;
  public Integer get_session_id() {
    return session_id;
  }
  public void set_session_id(Integer session_id) {
    this.session_id = session_id;
  }
  public ctr with_session_id(Integer session_id) {
    this.session_id = session_id;
    return this;
  }
  private java.sql.Timestamp datetime;
  public java.sql.Timestamp get_datetime() {
    return datetime;
  }
  public void set_datetime(java.sql.Timestamp datetime) {
    this.datetime = datetime;
  }
  public ctr with_datetime(java.sql.Timestamp datetime) {
    this.datetime = datetime;
    return this;
  }
  private Integer user_id;
  public Integer get_user_id() {
    return user_id;
  }
  public void set_user_id(Integer user_id) {
    this.user_id = user_id;
  }
  public ctr with_user_id(Integer user_id) {
    this.user_id = user_id;
    return this;
  }
  private String product;
  public String get_product() {
    return product;
  }
  public void set_product(String product) {
    this.product = product;
  }
  public ctr with_product(String product) {
    this.product = product;
    return this;
  }
  private Integer campaign_id;
  public Integer get_campaign_id() {
    return campaign_id;
  }
  public void set_campaign_id(Integer campaign_id) {
    this.campaign_id = campaign_id;
  }
  public ctr with_campaign_id(Integer campaign_id) {
    this.campaign_id = campaign_id;
    return this;
  }
  private Integer webpage_id;
  public Integer get_webpage_id() {
    return webpage_id;
  }
  public void set_webpage_id(Integer webpage_id) {
    this.webpage_id = webpage_id;
  }
  public ctr with_webpage_id(Integer webpage_id) {
    this.webpage_id = webpage_id;
    return this;
  }
  private Integer product_category_1;
  public Integer get_product_category_1() {
    return product_category_1;
  }
  public void set_product_category_1(Integer product_category_1) {
    this.product_category_1 = product_category_1;
  }
  public ctr with_product_category_1(Integer product_category_1) {
    this.product_category_1 = product_category_1;
    return this;
  }
  private Double product_category_2;
  public Double get_product_category_2() {
    return product_category_2;
  }
  public void set_product_category_2(Double product_category_2) {
    this.product_category_2 = product_category_2;
  }
  public ctr with_product_category_2(Double product_category_2) {
    this.product_category_2 = product_category_2;
    return this;
  }
  private Double user_group_id;
  public Double get_user_group_id() {
    return user_group_id;
  }
  public void set_user_group_id(Double user_group_id) {
    this.user_group_id = user_group_id;
  }
  public ctr with_user_group_id(Double user_group_id) {
    this.user_group_id = user_group_id;
    return this;
  }
  private String gender;
  public String get_gender() {
    return gender;
  }
  public void set_gender(String gender) {
    this.gender = gender;
  }
  public ctr with_gender(String gender) {
    this.gender = gender;
    return this;
  }
  private Double age_level;
  public Double get_age_level() {
    return age_level;
  }
  public void set_age_level(Double age_level) {
    this.age_level = age_level;
  }
  public ctr with_age_level(Double age_level) {
    this.age_level = age_level;
    return this;
  }
  private Double user_depth;
  public Double get_user_depth() {
    return user_depth;
  }
  public void set_user_depth(Double user_depth) {
    this.user_depth = user_depth;
  }
  public ctr with_user_depth(Double user_depth) {
    this.user_depth = user_depth;
    return this;
  }
  private Double city_development_index;
  public Double get_city_development_index() {
    return city_development_index;
  }
  public void set_city_development_index(Double city_development_index) {
    this.city_development_index = city_development_index;
  }
  public ctr with_city_development_index(Double city_development_index) {
    this.city_development_index = city_development_index;
    return this;
  }
  private Integer var_1;
  public Integer get_var_1() {
    return var_1;
  }
  public void set_var_1(Integer var_1) {
    this.var_1 = var_1;
  }
  public ctr with_var_1(Integer var_1) {
    this.var_1 = var_1;
    return this;
  }
  private Integer is_click;
  public Integer get_is_click() {
    return is_click;
  }
  public void set_is_click(Integer is_click) {
    this.is_click = is_click;
  }
  public ctr with_is_click(Integer is_click) {
    this.is_click = is_click;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ctr)) {
      return false;
    }
    ctr that = (ctr) o;
    boolean equal = true;
    equal = equal && (this.session_id == null ? that.session_id == null : this.session_id.equals(that.session_id));
    equal = equal && (this.datetime == null ? that.datetime == null : this.datetime.equals(that.datetime));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.product == null ? that.product == null : this.product.equals(that.product));
    equal = equal && (this.campaign_id == null ? that.campaign_id == null : this.campaign_id.equals(that.campaign_id));
    equal = equal && (this.webpage_id == null ? that.webpage_id == null : this.webpage_id.equals(that.webpage_id));
    equal = equal && (this.product_category_1 == null ? that.product_category_1 == null : this.product_category_1.equals(that.product_category_1));
    equal = equal && (this.product_category_2 == null ? that.product_category_2 == null : this.product_category_2.equals(that.product_category_2));
    equal = equal && (this.user_group_id == null ? that.user_group_id == null : this.user_group_id.equals(that.user_group_id));
    equal = equal && (this.gender == null ? that.gender == null : this.gender.equals(that.gender));
    equal = equal && (this.age_level == null ? that.age_level == null : this.age_level.equals(that.age_level));
    equal = equal && (this.user_depth == null ? that.user_depth == null : this.user_depth.equals(that.user_depth));
    equal = equal && (this.city_development_index == null ? that.city_development_index == null : this.city_development_index.equals(that.city_development_index));
    equal = equal && (this.var_1 == null ? that.var_1 == null : this.var_1.equals(that.var_1));
    equal = equal && (this.is_click == null ? that.is_click == null : this.is_click.equals(that.is_click));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ctr)) {
      return false;
    }
    ctr that = (ctr) o;
    boolean equal = true;
    equal = equal && (this.session_id == null ? that.session_id == null : this.session_id.equals(that.session_id));
    equal = equal && (this.datetime == null ? that.datetime == null : this.datetime.equals(that.datetime));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.product == null ? that.product == null : this.product.equals(that.product));
    equal = equal && (this.campaign_id == null ? that.campaign_id == null : this.campaign_id.equals(that.campaign_id));
    equal = equal && (this.webpage_id == null ? that.webpage_id == null : this.webpage_id.equals(that.webpage_id));
    equal = equal && (this.product_category_1 == null ? that.product_category_1 == null : this.product_category_1.equals(that.product_category_1));
    equal = equal && (this.product_category_2 == null ? that.product_category_2 == null : this.product_category_2.equals(that.product_category_2));
    equal = equal && (this.user_group_id == null ? that.user_group_id == null : this.user_group_id.equals(that.user_group_id));
    equal = equal && (this.gender == null ? that.gender == null : this.gender.equals(that.gender));
    equal = equal && (this.age_level == null ? that.age_level == null : this.age_level.equals(that.age_level));
    equal = equal && (this.user_depth == null ? that.user_depth == null : this.user_depth.equals(that.user_depth));
    equal = equal && (this.city_development_index == null ? that.city_development_index == null : this.city_development_index.equals(that.city_development_index));
    equal = equal && (this.var_1 == null ? that.var_1 == null : this.var_1.equals(that.var_1));
    equal = equal && (this.is_click == null ? that.is_click == null : this.is_click.equals(that.is_click));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.session_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.datetime = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.user_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.product = JdbcWritableBridge.readString(4, __dbResults);
    this.campaign_id = JdbcWritableBridge.readInteger(5, __dbResults);
    this.webpage_id = JdbcWritableBridge.readInteger(6, __dbResults);
    this.product_category_1 = JdbcWritableBridge.readInteger(7, __dbResults);
    this.product_category_2 = JdbcWritableBridge.readDouble(8, __dbResults);
    this.user_group_id = JdbcWritableBridge.readDouble(9, __dbResults);
    this.gender = JdbcWritableBridge.readString(10, __dbResults);
    this.age_level = JdbcWritableBridge.readDouble(11, __dbResults);
    this.user_depth = JdbcWritableBridge.readDouble(12, __dbResults);
    this.city_development_index = JdbcWritableBridge.readDouble(13, __dbResults);
    this.var_1 = JdbcWritableBridge.readInteger(14, __dbResults);
    this.is_click = JdbcWritableBridge.readInteger(15, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.session_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.datetime = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.user_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.product = JdbcWritableBridge.readString(4, __dbResults);
    this.campaign_id = JdbcWritableBridge.readInteger(5, __dbResults);
    this.webpage_id = JdbcWritableBridge.readInteger(6, __dbResults);
    this.product_category_1 = JdbcWritableBridge.readInteger(7, __dbResults);
    this.product_category_2 = JdbcWritableBridge.readDouble(8, __dbResults);
    this.user_group_id = JdbcWritableBridge.readDouble(9, __dbResults);
    this.gender = JdbcWritableBridge.readString(10, __dbResults);
    this.age_level = JdbcWritableBridge.readDouble(11, __dbResults);
    this.user_depth = JdbcWritableBridge.readDouble(12, __dbResults);
    this.city_development_index = JdbcWritableBridge.readDouble(13, __dbResults);
    this.var_1 = JdbcWritableBridge.readInteger(14, __dbResults);
    this.is_click = JdbcWritableBridge.readInteger(15, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(session_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(datetime, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(user_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(product, 4 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(campaign_id, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(webpage_id, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(product_category_1, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(product_category_2, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(user_group_id, 9 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(gender, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(age_level, 11 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(user_depth, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(city_development_index, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(var_1, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(is_click, 15 + __off, 4, __dbStmt);
    return 15;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(session_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(datetime, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(user_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(product, 4 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(campaign_id, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(webpage_id, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(product_category_1, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(product_category_2, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(user_group_id, 9 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(gender, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(age_level, 11 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(user_depth, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(city_development_index, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(var_1, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(is_click, 15 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.session_id = null;
    } else {
    this.session_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.datetime = null;
    } else {
    this.datetime = new Timestamp(__dataIn.readLong());
    this.datetime.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.user_id = null;
    } else {
    this.user_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.product = null;
    } else {
    this.product = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.campaign_id = null;
    } else {
    this.campaign_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.webpage_id = null;
    } else {
    this.webpage_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.product_category_1 = null;
    } else {
    this.product_category_1 = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.product_category_2 = null;
    } else {
    this.product_category_2 = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.user_group_id = null;
    } else {
    this.user_group_id = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.gender = null;
    } else {
    this.gender = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.age_level = null;
    } else {
    this.age_level = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.user_depth = null;
    } else {
    this.user_depth = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.city_development_index = null;
    } else {
    this.city_development_index = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.var_1 = null;
    } else {
    this.var_1 = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.is_click = null;
    } else {
    this.is_click = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.session_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.session_id);
    }
    if (null == this.datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.datetime.getTime());
    __dataOut.writeInt(this.datetime.getNanos());
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.user_id);
    }
    if (null == this.product) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, product);
    }
    if (null == this.campaign_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.campaign_id);
    }
    if (null == this.webpage_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.webpage_id);
    }
    if (null == this.product_category_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.product_category_1);
    }
    if (null == this.product_category_2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.product_category_2);
    }
    if (null == this.user_group_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.user_group_id);
    }
    if (null == this.gender) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gender);
    }
    if (null == this.age_level) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.age_level);
    }
    if (null == this.user_depth) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.user_depth);
    }
    if (null == this.city_development_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.city_development_index);
    }
    if (null == this.var_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.var_1);
    }
    if (null == this.is_click) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.is_click);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.session_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.session_id);
    }
    if (null == this.datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.datetime.getTime());
    __dataOut.writeInt(this.datetime.getNanos());
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.user_id);
    }
    if (null == this.product) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, product);
    }
    if (null == this.campaign_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.campaign_id);
    }
    if (null == this.webpage_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.webpage_id);
    }
    if (null == this.product_category_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.product_category_1);
    }
    if (null == this.product_category_2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.product_category_2);
    }
    if (null == this.user_group_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.user_group_id);
    }
    if (null == this.gender) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gender);
    }
    if (null == this.age_level) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.age_level);
    }
    if (null == this.user_depth) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.user_depth);
    }
    if (null == this.city_development_index) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.city_development_index);
    }
    if (null == this.var_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.var_1);
    }
    if (null == this.is_click) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.is_click);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(session_id==null?"null":"" + session_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(datetime==null?"null":"" + datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":"" + user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product==null?"null":product, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(campaign_id==null?"null":"" + campaign_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(webpage_id==null?"null":"" + webpage_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product_category_1==null?"null":"" + product_category_1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product_category_2==null?"null":"" + product_category_2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_group_id==null?"null":"" + user_group_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gender==null?"null":gender, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(age_level==null?"null":"" + age_level, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_depth==null?"null":"" + user_depth, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city_development_index==null?"null":"" + city_development_index, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(var_1==null?"null":"" + var_1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(is_click==null?"null":"" + is_click, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(session_id==null?"null":"" + session_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(datetime==null?"null":"" + datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":"" + user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product==null?"null":product, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(campaign_id==null?"null":"" + campaign_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(webpage_id==null?"null":"" + webpage_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product_category_1==null?"null":"" + product_category_1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(product_category_2==null?"null":"" + product_category_2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_group_id==null?"null":"" + user_group_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gender==null?"null":gender, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(age_level==null?"null":"" + age_level, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_depth==null?"null":"" + user_depth, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city_development_index==null?"null":"" + city_development_index, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(var_1==null?"null":"" + var_1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(is_click==null?"null":"" + is_click, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.session_id = null; } else {
      this.session_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.datetime = null; } else {
      this.datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_id = null; } else {
      this.user_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.product = null; } else {
      this.product = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.campaign_id = null; } else {
      this.campaign_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.webpage_id = null; } else {
      this.webpage_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.product_category_1 = null; } else {
      this.product_category_1 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.product_category_2 = null; } else {
      this.product_category_2 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_group_id = null; } else {
      this.user_group_id = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gender = null; } else {
      this.gender = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.age_level = null; } else {
      this.age_level = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_depth = null; } else {
      this.user_depth = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.city_development_index = null; } else {
      this.city_development_index = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.var_1 = null; } else {
      this.var_1 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.is_click = null; } else {
      this.is_click = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.session_id = null; } else {
      this.session_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.datetime = null; } else {
      this.datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_id = null; } else {
      this.user_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.product = null; } else {
      this.product = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.campaign_id = null; } else {
      this.campaign_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.webpage_id = null; } else {
      this.webpage_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.product_category_1 = null; } else {
      this.product_category_1 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.product_category_2 = null; } else {
      this.product_category_2 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_group_id = null; } else {
      this.user_group_id = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gender = null; } else {
      this.gender = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.age_level = null; } else {
      this.age_level = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.user_depth = null; } else {
      this.user_depth = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.city_development_index = null; } else {
      this.city_development_index = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.var_1 = null; } else {
      this.var_1 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.is_click = null; } else {
      this.is_click = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    ctr o = (ctr) super.clone();
    o.datetime = (o.datetime != null) ? (java.sql.Timestamp) o.datetime.clone() : null;
    return o;
  }

  public void clone0(ctr o) throws CloneNotSupportedException {
    o.datetime = (o.datetime != null) ? (java.sql.Timestamp) o.datetime.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("session_id", this.session_id);
    __sqoop$field_map.put("datetime", this.datetime);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("product", this.product);
    __sqoop$field_map.put("campaign_id", this.campaign_id);
    __sqoop$field_map.put("webpage_id", this.webpage_id);
    __sqoop$field_map.put("product_category_1", this.product_category_1);
    __sqoop$field_map.put("product_category_2", this.product_category_2);
    __sqoop$field_map.put("user_group_id", this.user_group_id);
    __sqoop$field_map.put("gender", this.gender);
    __sqoop$field_map.put("age_level", this.age_level);
    __sqoop$field_map.put("user_depth", this.user_depth);
    __sqoop$field_map.put("city_development_index", this.city_development_index);
    __sqoop$field_map.put("var_1", this.var_1);
    __sqoop$field_map.put("is_click", this.is_click);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("session_id", this.session_id);
    __sqoop$field_map.put("datetime", this.datetime);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("product", this.product);
    __sqoop$field_map.put("campaign_id", this.campaign_id);
    __sqoop$field_map.put("webpage_id", this.webpage_id);
    __sqoop$field_map.put("product_category_1", this.product_category_1);
    __sqoop$field_map.put("product_category_2", this.product_category_2);
    __sqoop$field_map.put("user_group_id", this.user_group_id);
    __sqoop$field_map.put("gender", this.gender);
    __sqoop$field_map.put("age_level", this.age_level);
    __sqoop$field_map.put("user_depth", this.user_depth);
    __sqoop$field_map.put("city_development_index", this.city_development_index);
    __sqoop$field_map.put("var_1", this.var_1);
    __sqoop$field_map.put("is_click", this.is_click);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
