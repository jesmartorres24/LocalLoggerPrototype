package MMA;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MetadataManagerPageObjects {

    public static By CreateChildNodeButton = By
            .cssSelector("button[id=metadata-create-new-node-button]  span[class=font-weight-bold]");

    public static List<WebElement> CreateChildNodeButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(CreateChildNodeButton);
    }

    public static By CreateParentNodeButton = By.cssSelector("button[id=metadata-create-new-node-button]");

    public static WebElement CreateParentNodeButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(CreateParentNodeButton);
    }

    public static By ParentNodeToBeSelected = By.cssSelector("div[class=v-treeview-node__content]");

    public static WebElement ParentNodeToBeSelected(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ParentNodeToBeSelected);
    }

    public static By ParentNodeToBeSelectedList = By
            .cssSelector("div[class=v-treeview-node__root] div[class=v-treeview-node__label]");

    public static List<WebElement> ParentNodeToBeSelectedList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(ParentNodeToBeSelectedList);
    }

    public static By SelectedNode = By.cssSelector("div[class*=\"v-treeview-node--active\"]");

    public static WebElement SelectedNode(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SelectedNode);
    }

    public static By MetadataManagerHeader = By.cssSelector("span[id=\"metadata-manager-header\"]");

    public static WebElement MetadataManagerHeader(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(MetadataManagerHeader);
    }

    public static By SelectedNodeOptionsDropdownButton = By.cssSelector("button[id=\"profile-menu\"]");

    public static WebElement SelectedNodeOptionsDropdownButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SelectedNodeOptionsDropdownButton);
    }

    public static By SelectedNodeOptionsDropdownAddButton = By.cssSelector("div[class*=v-list-item__title]");

    public static WebElement SelectedNodeOptionsDropdownAddButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SelectedNodeOptionsDropdownAddButton);
    }

    public static By NodeProfileList = By.cssSelector("div[class*=v-slide-group__content] a span");

    public static List<WebElement> NodeProfileList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(NodeProfileList);
    }

    public static By SelectedNodeOptionsDropdownEditButton = By
            .cssSelector("div[class=\"v-list-item__content py-0\"]:nth-child(2)");

    public static WebElement SelectedNodeOptionsDropdownEditButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SelectedNodeOptionsDropdownEditButton);
    }

    public static By SelectedNodeOptionsDropdownDeleteButton = By
            .cssSelector("div[class=\"v-list-item__content py-0\"]:nth-child(3)");

    public static WebElement SelectedNodeOptionsDropdownDeleteButton(SearchContext driver)
            throws NoSuchElementException {
        return driver.findElement(SelectedNodeOptionsDropdownDeleteButton);
    }

    public static By SelectedNodeDefaultProfileTab = By.partialLinkText("Default");

    public static WebElement SelectedNodeDefaultProfileTab(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SelectedNodeDefaultProfileTab);
    }

    public static By EditNodeButton = By.cssSelector("button[id=metadata-edit-node-button]");

    public static WebElement EditNodeButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(EditNodeButton);
    }

    public static By DeleteParentNodeButton = By.cssSelector("button[id=metadata-delete-node-button]");

    public static WebElement DeleteParentNodeButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(DeleteParentNodeButton);
    }

    public static By ActiveNodeCaretButton = By.cssSelector("div[class*=v-treeview-node--active] button");

    public static WebElement ActiveNodeCaretButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ActiveNodeCaretButton);
    }

    public static By ChildNodeToBeSelectedList = By.cssSelector(
            "div[class=v-treeview-node__children] div[class=v-treeview-node__content] div[class=v-treeview-node__label]");

    public static List<WebElement> ChildNodeToBeSelectedList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(ChildNodeToBeSelectedList);
    }

    public static By ToastMessageBanner = By.cssSelector("div[class=v-snack__content]");

    public static WebElement ToastMessageBanner(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ToastMessageBanner);
    }

    public static By NodeProfileTabContainer = By.cssSelector("div[class=v-slide-group__wrapper]");

    public static WebElement NodeProfileTabContainer(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(NodeProfileTabContainer);
    }

    public static By ActiveNodeProfileTab = By.cssSelector("div a[aria-selected=true] span");

    public static WebElement ActiveNodeProfileTab(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ActiveNodeProfileTab);
    }

    public static By NodeSpinner = By.cssSelector("button[class*=toggle--loading]");

    public static WebElement NodeSpinner(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(NodeSpinner);
    }

    public static By ActiveNode = By.cssSelector("div[class*=v-treeview-node--active]");

    public static WebElement ActiveNode(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ActiveNode);
    }

    public static By ChildOfChildNodeTreeView = By
            .cssSelector("div[aria-expanded=true] div[aria-expanded=true] div[aria-expanded=true]");

    public static WebElement TreeView(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ChildOfChildNodeTreeView);
    }

    public static By NodeProfileField = By.cssSelector("div[class=\"v-card v-card--flat v-sheet theme--light\"]");

    public static WebElement NodeProfileField(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(NodeProfileField);
    }

    public static By ParentNodeField = By
            .cssSelector("div[class=\"v-treeview ml-4 v-treeview--hoverable v-treeview--dense theme--light\"]");

    public static WebElement ParentNodeField(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ParentNodeField);
    }

    //MMAv2 new UI pageObjects

    public static By MetadataManagerWelcomeHeader = By.cssSelector("h3[class*=metadata-manager-welcome-header]");

    public static WebElement MetadataManagerWelcomeHeader(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(MetadataManagerWelcomeHeader);
    }

    public static By SearchBar = By.cssSelector("input[id=\"input-129\"]");

    public static WebElement SearchBar(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(SearchBar);
    }

    public static By clearSearchBarButton = By.cssSelector("button[aria-label=\"clear icon\"]");

    public static WebElement clearSearchBarButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(clearSearchBarButton);
    }

    public static By createBranchButton = By.cssSelector("div[class=\"v-list-item__content\"] span[class=\"v-btn__content\"]");

    public static WebElement createBranchButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(createBranchButton);
    }

    public static By ParentBranchList = By.cssSelector(".v-treeview-node__root:has(i[class*=mdi-file-tree-outline])");

    public static List<WebElement> ParentBranchList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(ParentBranchList);
    }

    public static By childbranchList = By.cssSelector(".v-treeview-node__root:has(i[class*=mdi-file-document])");

    public static List<WebElement> childbranchList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(childbranchList);
    }

    public static By ActiveBranch = By.cssSelector("div[class*=node--active]");

    public static WebElement ActiveBranch(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(ActiveBranch);
    }

    public static By childBranchList = By.cssSelector("div[class=\"v-treeview-node__children\"] div[class=\"v-treeview-node\"]");

    public static List<WebElement> childBranchList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(childBranchList);
    }


    public static By ActiveBranchExpandedList = By.cssSelector("div[class*=node--active] button[class*=v-treeview-node__toggle--open]");

    public static List<WebElement> ActiveBranchExpandedList(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(ActiveBranchExpandedList);
    }

    public static By toastMessage = By.cssSelector("div[class*=v-snack__wrapper]");

    public static List<WebElement> toastMessage(SearchContext driver) throws NoSuchElementException {
        return driver.findElements(toastMessage);
    }

    public static By activeBranchCaretButton = By.cssSelector("div[class*=v-treeview-node--active] button");

    public static WebElement activeBranchCaretButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(activeBranchCaretButton);
    }

    public static By activeBranchCaretButtonEnabled = By.cssSelector("div[class*=v-treeview-node--active] button[class*=v-treeview-node__toggle--open]");

    public static WebElement activeBranchCaretButtonEnabled(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(activeBranchCaretButtonEnabled);
    }

    public static By createProfileButton = By.cssSelector(".mr-auto~div #metadata-edit-node-button");

    public static WebElement createProfileButton(SearchContext driver) throws NoSuchElementException {
        return driver.findElement(createProfileButton);
    }



}
