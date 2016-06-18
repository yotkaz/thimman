import {Project} from "./project";
import {Skill} from "./skill";
import {Challenge} from "./challenge";
export class JobOffer {
    id: number;
    name: string;
    description: string;
    status: string;
    project: Project;
    requiredSkills: Skill[] = [];
    challenges: Challenge[] = [];
}