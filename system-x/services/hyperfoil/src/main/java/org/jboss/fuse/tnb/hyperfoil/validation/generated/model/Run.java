/*
 * Hyperfoil Controller API
 * Hyperfoil Controller API
 *
 * The version of the OpenAPI document: 0.5
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.jboss.fuse.tnb.hyperfoil.validation.generated.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Run
 */
public class Run {
    public static final String SERIALIZED_NAME_ID = "id";
    public static final String SERIALIZED_NAME_BENCHMARK = "benchmark";
    public static final String SERIALIZED_NAME_STARTED = "started";
    public static final String SERIALIZED_NAME_TERMINATED = "terminated";
    public static final String SERIALIZED_NAME_CANCELLED = "cancelled";
    public static final String SERIALIZED_NAME_COMPLETED = "completed";
    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    public static final String SERIALIZED_NAME_PHASES = "phases";
    public static final String SERIALIZED_NAME_AGENTS = "agents";
    public static final String SERIALIZED_NAME_ERRORS = "errors";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;
    @SerializedName(SERIALIZED_NAME_BENCHMARK)
    private String benchmark;
    @SerializedName(SERIALIZED_NAME_STARTED)
    private String started;
    @SerializedName(SERIALIZED_NAME_TERMINATED)
    private String terminated;
    @SerializedName(SERIALIZED_NAME_CANCELLED)
    private Boolean cancelled;
    @SerializedName(SERIALIZED_NAME_COMPLETED)
    private Boolean completed;
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @SerializedName(SERIALIZED_NAME_PHASES)
    private List<Phase> phases = null;
    @SerializedName(SERIALIZED_NAME_AGENTS)
    private List<Agent> agents = null;
    @SerializedName(SERIALIZED_NAME_ERRORS)
    private List<String> errors = null;

    public Run() {
    }

    public Run id(String id) {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Run benchmark(String benchmark) {

        this.benchmark = benchmark;
        return this;
    }

    /**
     * Get benchmark
     *
     * @return benchmark
     **/
    
    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public Run started(String started) {

        this.started = started;
        return this;
    }

    /**
     * Get started
     *
     * @return started
     **/
    
    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public Run terminated(String terminated) {

        this.terminated = terminated;
        return this;
    }

    /**
     * Get terminated
     *
     * @return terminated
     **/
    
    public String getTerminated() {
        return terminated;
    }

    public void setTerminated(String terminated) {
        this.terminated = terminated;
    }

    public Run cancelled(Boolean cancelled) {

        this.cancelled = cancelled;
        return this;
    }

    /**
     * Get cancelled
     *
     * @return cancelled
     **/
    

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Run completed(Boolean completed) {

        this.completed = completed;
        return this;
    }

    /**
     * Get completed
     *
     * @return completed
     **/
    

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Run description(String description) {

        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Run phases(List<Phase> phases) {

        this.phases = phases;
        return this;
    }

    public Run addPhasesItem(Phase phasesItem) {
        if (this.phases == null) {
            this.phases = new ArrayList<Phase>();
        }
        this.phases.add(phasesItem);
        return this;
    }

    /**
     * Get phases
     *
     * @return phases
     **/
    

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public Run agents(List<Agent> agents) {

        this.agents = agents;
        return this;
    }

    public Run addAgentsItem(Agent agentsItem) {
        if (this.agents == null) {
            this.agents = new ArrayList<Agent>();
        }
        this.agents.add(agentsItem);
        return this;
    }

    /**
     * Get agents
     *
     * @return agents
     **/
    

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public Run errors(List<String> errors) {

        this.errors = errors;
        return this;
    }

    public Run addErrorsItem(String errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Get errors
     *
     * @return errors
     **/
    

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Run run = (Run) o;
        return Objects.equals(this.id, run.id)
            && Objects.equals(this.benchmark, run.benchmark)
            && Objects.equals(this.started, run.started)
            && Objects.equals(this.terminated, run.terminated)
            && Objects.equals(this.cancelled, run.cancelled)
            && Objects.equals(this.completed, run.completed)
            && Objects.equals(this.description, run.description)
            && Objects.equals(this.phases, run.phases)
            && Objects.equals(this.agents, run.agents)
            && Objects.equals(this.errors, run.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, benchmark, started, terminated, cancelled, completed, description, phases, agents, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Run {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    benchmark: ").append(toIndentedString(benchmark)).append("\n");
        sb.append("    started: ").append(toIndentedString(started)).append("\n");
        sb.append("    terminated: ").append(toIndentedString(terminated)).append("\n");
        sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
        sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    phases: ").append(toIndentedString(phases)).append("\n");
        sb.append("    agents: ").append(toIndentedString(agents)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
