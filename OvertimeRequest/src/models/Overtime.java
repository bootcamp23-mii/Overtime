/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AdhityaWP
 */
@Entity
@Table(name = "OVERTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Overtime.findAll", query = "SELECT o FROM Overtime o")
    , @NamedQuery(name = "Overtime.findById", query = "SELECT o FROM Overtime o WHERE o.id = :id")
    , @NamedQuery(name = "Overtime.findByOvertimeDate", query = "SELECT o FROM Overtime o WHERE o.overtimeDate = :overtimeDate")
    , @NamedQuery(name = "Overtime.findByTimeDuration", query = "SELECT o FROM Overtime o WHERE o.timeDuration = :timeDuration")
    , @NamedQuery(name = "Overtime.findByKeterangan", query = "SELECT o FROM Overtime o WHERE o.keterangan = :keterangan")
    , @NamedQuery(name = "Overtime.findByStatus", query = "SELECT o FROM Overtime o WHERE o.status = :status")})
public class Overtime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "OVERTIME_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date overtimeDate;
    @Column(name = "TIME_DURATION")
    private BigInteger timeDuration;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(mappedBy = "overtime", fetch = FetchType.LAZY)
    private List<Task> taskList;
    @JoinColumn(name = "TIME_SHEET", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TimeSheet timeSheet;

    public Overtime() {
    }

    public Overtime(String id) {
        this.id = id;
    }

    public Overtime(String id, Date overtimeDate, BigInteger timeDuration, String keterangan, BigInteger status, TimeSheet timeSheet) {
        this.id = id;
        this.overtimeDate = overtimeDate;
        this.timeDuration = timeDuration;
        this.keterangan = keterangan;
        this.status = status;
        this.timeSheet = timeSheet;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOvertimeDate() {
        return overtimeDate;
    }

    public void setOvertimeDate(Date overtimeDate) {
        this.overtimeDate = overtimeDate;
    }

    public BigInteger getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(BigInteger timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    public void setTimeSheet(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Overtime)) {
            return false;
        }
        Overtime other = (Overtime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Overtime[ id=" + id + " ]";
    }
    
}
